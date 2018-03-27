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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
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
        if (!v.E(list)) {
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
    /* renamed from: op */
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
            view = LayoutInflater.from(this.mContext).inflate(d.h.god_recommend_list_item, (ViewGroup) null);
            C0161a c0161a2 = new C0161a();
            c0161a2.cJp = (ClickableHeaderImageView) view.findViewById(d.g.photo);
            c0161a2.cql = (TextView) view.findViewById(d.g.user_name);
            c0161a2.edF = (TextView) view.findViewById(d.g.god_info);
            c0161a2.edG = (TextView) view.findViewById(d.g.fans_and_thread_count);
            c0161a2.edH = (TextView) view.findViewById(d.g.attention_btn);
            c0161a2.cIj = view.findViewById(d.g.bottom_line);
            view.setTag(c0161a2);
            c0161a = c0161a2;
        } else {
            c0161a = (C0161a) view.getTag();
        }
        a(c0161a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            c(c0161a.edH, item.getGodUserData().getIsLike());
            c0161a.cJp.setGodIconMargin(0);
            c0161a.cJp.setClickable(false);
            c0161a.cJp.startLoad(portrait, 28, false);
            c0161a.cJp.setIsBigV(true);
            c0161a.cJp.setShowV(true);
            c0161a.cql.setText(item.getUserName());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0161a.edF.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0161a.edF.setText(UtilHelper.getFixedBarText(this.mContext.getString(d.j.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0161a.edF.setVisibility(8);
                    break;
            }
            c0161a.edG.setText(am.J(item.getFansNum()) + this.mContext.getString(d.j.fans_default_name) + " " + am.J(item.getLikeNum()) + this.mContext.getString(d.j.zan));
        }
        if (i == getCount() - 1) {
            c0161a.cIj.setVisibility(8);
        } else {
            c0161a.cIj.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0161a.edH.setTag(item);
            c0161a.edH.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0161a c0161a) {
        if (c0161a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0161a.mSkinType != skinType) {
                aj.r(c0161a.cql, d.C0141d.cp_cont_h);
                aj.r(c0161a.edF, d.C0141d.cp_cont_d);
                aj.r(c0161a.edG, d.C0141d.cp_cont_d);
                aj.t(c0161a.cIj, d.C0141d.cp_bg_line_b);
            }
            c0161a.mSkinType = skinType;
        }
    }

    private void c(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            aj.e(textView, d.C0141d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.e(textView, d.C0141d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(d.j.attention));
        aj.s(textView, d.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0161a {
        public View cIj;
        public ClickableHeaderImageView cJp;
        public TextView cql;
        public TextView edF;
        public TextView edG;
        public TextView edH;
        public int mSkinType;

        private C0161a() {
            this.mSkinType = 3;
        }
    }
}
