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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
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
        if (!v.w(list)) {
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
    /* renamed from: lO */
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0145a c0145a;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.god_recommend_list_item, (ViewGroup) null);
            C0145a c0145a2 = new C0145a();
            c0145a2.bZz = (ClickableHeaderImageView) view2.findViewById(d.g.photo);
            c0145a2.bGp = (TextView) view2.findViewById(d.g.user_name);
            c0145a2.dyl = (TextView) view2.findViewById(d.g.god_info);
            c0145a2.dym = (TextView) view2.findViewById(d.g.fans_and_thread_count);
            c0145a2.dyn = (TextView) view2.findViewById(d.g.attention_btn);
            c0145a2.bYq = view2.findViewById(d.g.bottom_line);
            view2.setTag(c0145a2);
            c0145a = c0145a2;
        } else {
            c0145a = (C0145a) view2.getTag();
        }
        a(c0145a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            c(c0145a.dyn, item.getGodUserData().getIsLike());
            c0145a.bZz.setGodIconMargin(0);
            c0145a.bZz.setClickable(false);
            c0145a.bZz.startLoad(portrait, 28, false);
            c0145a.bZz.setIsBigV(true);
            c0145a.bZz.setShowV(true);
            c0145a.bGp.setText(item.getUserName());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0145a.dyl.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0145a.dyl.setText(UtilHelper.getFixedBarText(this.mContext.getString(d.k.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0145a.dyl.setVisibility(8);
                    break;
            }
            c0145a.dym.setText(an.B(item.getFansNum()) + this.mContext.getString(d.k.fans_default_name) + " " + an.B(item.getLikeNum()) + this.mContext.getString(d.k.zan));
        }
        if (i == getCount() - 1) {
            c0145a.bYq.setVisibility(8);
        } else {
            c0145a.bYq.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0145a.dyn.setTag(item);
            c0145a.dyn.setOnClickListener(this.mOnClickListener);
        }
        return view2;
    }

    private void a(C0145a c0145a) {
        if (c0145a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0145a.mSkinType != skinType) {
                ak.h(c0145a.bGp, d.C0126d.cp_cont_h);
                ak.h(c0145a.dyl, d.C0126d.cp_cont_d);
                ak.h(c0145a.dym, d.C0126d.cp_cont_d);
                ak.j(c0145a.bYq, d.C0126d.cp_bg_line_b);
            }
            c0145a.mSkinType = skinType;
        }
    }

    private void c(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            ak.c(textView, d.C0126d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ak.c(textView, d.C0126d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(d.k.attention));
        ak.i(textView, d.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0145a {
        public TextView bGp;
        public View bYq;
        public ClickableHeaderImageView bZz;
        public TextView dyl;
        public TextView dym;
        public TextView dyn;
        public int mSkinType;

        private C0145a() {
            this.mSkinType = 3;
        }
    }
}
