package com.baidu.tieba.godRecommends;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<MetaData> mList = new ArrayList();
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        if (!w.z(list)) {
            this.mList.clear();
            this.mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ms */
    public MetaData getItem(int i) {
        if (i < this.mList.size()) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0161a c0161a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(f.h.god_recommend_list_item, (ViewGroup) null);
            C0161a c0161a2 = new C0161a();
            c0161a2.cmx = (ClickableHeaderImageView) view.findViewById(f.g.photo);
            c0161a2.bSQ = (TextView) view.findViewById(f.g.user_name);
            c0161a2.dQz = (TextView) view.findViewById(f.g.god_info);
            c0161a2.dQA = (TextView) view.findViewById(f.g.fans_and_thread_count);
            c0161a2.dhs = (TextView) view.findViewById(f.g.attention_btn);
            c0161a2.clf = view.findViewById(f.g.bottom_line);
            view.setTag(c0161a2);
            c0161a = c0161a2;
        } else {
            c0161a = (C0161a) view.getTag();
        }
        a(c0161a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0161a.dhs, item.getGodUserData().getIsLike());
            c0161a.cmx.setGodIconMargin(0);
            c0161a.cmx.setClickable(false);
            c0161a.cmx.startLoad(portrait, 28, false);
            c0161a.cmx.setIsBigV(true);
            c0161a.cmx.setShowV(true);
            c0161a.bSQ.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0161a.dQz.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0161a.dQz.setText(UtilHelper.getFixedBarText(this.mContext.getString(f.j.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0161a.dQz.setVisibility(8);
                    break;
            }
            c0161a.dQA.setText(ap.H(item.getFansNum()) + this.mContext.getString(f.j.fans_default_name) + " " + ap.H(item.getLikeNum()) + this.mContext.getString(f.j.zan));
        }
        if (i == getCount() - 1) {
            c0161a.clf.setVisibility(8);
        } else {
            c0161a.clf.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0161a.dhs.setTag(item);
            c0161a.dhs.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0161a c0161a) {
        if (c0161a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0161a.mSkinType != skinType) {
                am.h(c0161a.bSQ, f.d.cp_cont_h);
                am.h(c0161a.dQz, f.d.cp_cont_d);
                am.h(c0161a.dQA, f.d.cp_cont_d);
                am.j(c0161a.clf, f.d.cp_bg_line_b);
            }
            c0161a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            am.c(textView, f.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.c(textView, f.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(f.j.attention));
        am.i(textView, f.C0146f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0161a {
        public TextView bSQ;
        public View clf;
        public ClickableHeaderImageView cmx;
        public TextView dQA;
        public TextView dQz;
        public TextView dhs;
        public int mSkinType;

        private C0161a() {
            this.mSkinType = 3;
        }
    }
}
