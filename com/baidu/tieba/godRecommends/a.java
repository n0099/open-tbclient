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
        if (!w.A(list)) {
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
    /* renamed from: mg */
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.god_recommend_list_item, (ViewGroup) null);
            C0163a c0163a2 = new C0163a();
            c0163a2.ckM = (ClickableHeaderImageView) view.findViewById(d.g.photo);
            c0163a2.bRW = (TextView) view.findViewById(d.g.user_name);
            c0163a2.dNR = (TextView) view.findViewById(d.g.god_info);
            c0163a2.dNS = (TextView) view.findViewById(d.g.fans_and_thread_count);
            c0163a2.deE = (TextView) view.findViewById(d.g.attention_btn);
            c0163a2.cjz = view.findViewById(d.g.bottom_line);
            view.setTag(c0163a2);
            c0163a = c0163a2;
        } else {
            c0163a = (C0163a) view.getTag();
        }
        a(c0163a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0163a.deE, item.getGodUserData().getIsLike());
            c0163a.ckM.setGodIconMargin(0);
            c0163a.ckM.setClickable(false);
            c0163a.ckM.startLoad(portrait, 28, false);
            c0163a.ckM.setIsBigV(true);
            c0163a.ckM.setShowV(true);
            c0163a.bRW.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0163a.dNR.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0163a.dNR.setText(UtilHelper.getFixedBarText(this.mContext.getString(d.k.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0163a.dNR.setVisibility(8);
                    break;
            }
            c0163a.dNS.setText(ap.F(item.getFansNum()) + this.mContext.getString(d.k.fans_default_name) + " " + ap.F(item.getLikeNum()) + this.mContext.getString(d.k.zan));
        }
        if (i == getCount() - 1) {
            c0163a.cjz.setVisibility(8);
        } else {
            c0163a.cjz.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0163a.deE.setTag(item);
            c0163a.deE.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0163a c0163a) {
        if (c0163a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0163a.mSkinType != skinType) {
                am.h(c0163a.bRW, d.C0142d.cp_cont_h);
                am.h(c0163a.dNR, d.C0142d.cp_cont_d);
                am.h(c0163a.dNS, d.C0142d.cp_cont_d);
                am.j(c0163a.cjz, d.C0142d.cp_bg_line_b);
            }
            c0163a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            am.c(textView, d.C0142d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.c(textView, d.C0142d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(d.k.attention));
        am.i(textView, d.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0163a {
        public TextView bRW;
        public View cjz;
        public ClickableHeaderImageView ckM;
        public TextView dNR;
        public TextView dNS;
        public TextView deE;
        public int mSkinType;

        private C0163a() {
            this.mSkinType = 3;
        }
    }
}
