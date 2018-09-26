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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.e;
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
        if (!v.z(list)) {
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
    /* renamed from: mW */
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
        C0163a c0163a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.god_recommend_list_item, (ViewGroup) null);
            C0163a c0163a2 = new C0163a();
            c0163a2.csp = (ClickableHeaderImageView) view.findViewById(e.g.photo);
            c0163a2.bYF = (TextView) view.findViewById(e.g.user_name);
            c0163a2.dXR = (TextView) view.findViewById(e.g.god_info);
            c0163a2.dXS = (TextView) view.findViewById(e.g.fans_and_thread_count);
            c0163a2.dnk = (TextView) view.findViewById(e.g.attention_btn);
            c0163a2.cqY = view.findViewById(e.g.bottom_line);
            view.setTag(c0163a2);
            c0163a = c0163a2;
        } else {
            c0163a = (C0163a) view.getTag();
        }
        a(c0163a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0163a.dnk, item.getGodUserData().getIsLike());
            c0163a.csp.setGodIconMargin(0);
            c0163a.csp.setClickable(false);
            c0163a.csp.startLoad(portrait, 28, false);
            c0163a.csp.setIsBigV(true);
            c0163a.csp.setShowV(true);
            c0163a.bYF.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0163a.dXR.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0163a.dXR.setText(UtilHelper.getFixedBarText(this.mContext.getString(e.j.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0163a.dXR.setVisibility(8);
                    break;
            }
            c0163a.dXS.setText(ao.L(item.getFansNum()) + this.mContext.getString(e.j.fans_default_name) + " " + ao.L(item.getLikeNum()) + this.mContext.getString(e.j.zan));
        }
        if (i == getCount() - 1) {
            c0163a.cqY.setVisibility(8);
        } else {
            c0163a.cqY.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0163a.dnk.setTag(item);
            c0163a.dnk.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0163a c0163a) {
        if (c0163a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0163a.mSkinType != skinType) {
                al.h(c0163a.bYF, e.d.cp_cont_h);
                al.h(c0163a.dXR, e.d.cp_cont_d);
                al.h(c0163a.dXS, e.d.cp_cont_d);
                al.j(c0163a.cqY, e.d.cp_bg_line_b);
            }
            c0163a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            al.c(textView, e.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.c(textView, e.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(e.j.attention));
        al.i(textView, e.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0163a {
        public TextView bYF;
        public View cqY;
        public ClickableHeaderImageView csp;
        public TextView dXR;
        public TextView dXS;
        public TextView dnk;
        public int mSkinType;

        private C0163a() {
            this.mSkinType = 3;
        }
    }
}
