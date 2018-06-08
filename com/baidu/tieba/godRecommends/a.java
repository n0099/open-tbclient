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
import com.baidu.tbadk.core.util.w;
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
    /* renamed from: lZ */
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.god_recommend_list_item, (ViewGroup) null);
            C0161a c0161a2 = new C0161a();
            c0161a2.civ = (ClickableHeaderImageView) view.findViewById(d.g.photo);
            c0161a2.bPN = (TextView) view.findViewById(d.g.user_name);
            c0161a2.dKz = (TextView) view.findViewById(d.g.god_info);
            c0161a2.dKA = (TextView) view.findViewById(d.g.fans_and_thread_count);
            c0161a2.dKB = (TextView) view.findViewById(d.g.attention_btn);
            c0161a2.chp = view.findViewById(d.g.bottom_line);
            view.setTag(c0161a2);
            c0161a = c0161a2;
        } else {
            c0161a = (C0161a) view.getTag();
        }
        a(c0161a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            c(c0161a.dKB, item.getGodUserData().getIsLike());
            c0161a.civ.setGodIconMargin(0);
            c0161a.civ.setClickable(false);
            c0161a.civ.startLoad(portrait, 28, false);
            c0161a.civ.setIsBigV(true);
            c0161a.civ.setShowV(true);
            c0161a.bPN.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0161a.dKz.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0161a.dKz.setText(UtilHelper.getFixedBarText(this.mContext.getString(d.k.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0161a.dKz.setVisibility(8);
                    break;
            }
            c0161a.dKA.setText(ao.E(item.getFansNum()) + this.mContext.getString(d.k.fans_default_name) + " " + ao.E(item.getLikeNum()) + this.mContext.getString(d.k.zan));
        }
        if (i == getCount() - 1) {
            c0161a.chp.setVisibility(8);
        } else {
            c0161a.chp.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0161a.dKB.setTag(item);
            c0161a.dKB.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0161a c0161a) {
        if (c0161a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0161a.mSkinType != skinType) {
                al.h(c0161a.bPN, d.C0141d.cp_cont_h);
                al.h(c0161a.dKz, d.C0141d.cp_cont_d);
                al.h(c0161a.dKA, d.C0141d.cp_cont_d);
                al.j(c0161a.chp, d.C0141d.cp_bg_line_b);
            }
            c0161a.mSkinType = skinType;
        }
    }

    private void c(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            al.c(textView, d.C0141d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.c(textView, d.C0141d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(d.k.attention));
        al.i(textView, d.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0161a {
        public TextView bPN;
        public View chp;
        public ClickableHeaderImageView civ;
        public TextView dKA;
        public TextView dKB;
        public TextView dKz;
        public int mSkinType;

        private C0161a() {
            this.mSkinType = 3;
        }
    }
}
