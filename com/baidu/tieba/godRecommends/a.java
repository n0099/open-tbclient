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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private List<MetaData> mList = new ArrayList();
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        if (!v.T(list)) {
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
    /* renamed from: rZ */
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
        C0301a c0301a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.god_recommend_list_item, (ViewGroup) null);
            C0301a c0301a2 = new C0301a();
            c0301a2.dUE = (ClickableHeaderImageView) view.findViewById(d.g.photo);
            c0301a2.eeB = (TextView) view.findViewById(d.g.user_name);
            c0301a2.fDI = (TextView) view.findViewById(d.g.god_info);
            c0301a2.fDJ = (TextView) view.findViewById(d.g.fans_and_thread_count);
            c0301a2.eTD = (TextView) view.findViewById(d.g.attention_btn);
            c0301a2.dTe = view.findViewById(d.g.bottom_line);
            view.setTag(c0301a2);
            c0301a = c0301a2;
        } else {
            c0301a = (C0301a) view.getTag();
        }
        a(c0301a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0301a.eTD, item.getGodUserData().getIsLike());
            c0301a.dUE.setGodIconMargin(0);
            c0301a.dUE.setClickable(false);
            c0301a.dUE.startLoad(portrait, 28, false);
            c0301a.dUE.setIsBigV(true);
            c0301a.dUE.setShowV(true);
            c0301a.eeB.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0301a.fDI.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0301a.fDI.setText(UtilHelper.getFixedBarText(this.mContext.getString(d.j.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0301a.fDI.setVisibility(8);
                    break;
            }
            c0301a.fDJ.setText(ap.az(item.getFansNum()) + this.mContext.getString(d.j.fans_default_name) + " " + ap.az(item.getLikeNum()) + this.mContext.getString(d.j.zan));
        }
        if (i == getCount() - 1) {
            c0301a.dTe.setVisibility(8);
        } else {
            c0301a.dTe.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0301a.eTD.setTag(item);
            c0301a.eTD.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0301a c0301a) {
        if (c0301a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0301a.mSkinType != skinType) {
                al.j(c0301a.eeB, d.C0277d.cp_cont_h);
                al.j(c0301a.fDI, d.C0277d.cp_cont_d);
                al.j(c0301a.fDJ, d.C0277d.cp_cont_d);
                al.l(c0301a.dTe, d.C0277d.cp_bg_line_b);
            }
            c0301a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            al.d(textView, d.C0277d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.d(textView, d.C0277d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(d.j.attention));
        al.k(textView, d.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0301a {
        public View dTe;
        public ClickableHeaderImageView dUE;
        public TextView eTD;
        public TextView eeB;
        public TextView fDI;
        public TextView fDJ;
        public int mSkinType;

        private C0301a() {
            this.mSkinType = 3;
        }
    }
}
