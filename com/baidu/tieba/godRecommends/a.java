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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
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
        if (!v.aa(list)) {
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
    /* renamed from: tB */
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
        C0322a c0322a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.god_recommend_list_item, (ViewGroup) null);
            C0322a c0322a2 = new C0322a();
            c0322a2.ejP = (ClickableHeaderImageView) view.findViewById(R.id.photo);
            c0322a2.euj = (TextView) view.findViewById(R.id.user_name);
            c0322a2.gav = (TextView) view.findViewById(R.id.god_info);
            c0322a2.gaw = (TextView) view.findViewById(R.id.fans_and_thread_count);
            c0322a2.fpl = (TextView) view.findViewById(R.id.attention_btn);
            c0322a2.ein = view.findViewById(R.id.bottom_line);
            view.setTag(c0322a2);
            c0322a = c0322a2;
        } else {
            c0322a = (C0322a) view.getTag();
        }
        a(c0322a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0322a.fpl, item.getGodUserData().getIsLike());
            c0322a.ejP.setGodIconMargin(0);
            c0322a.ejP.setClickable(false);
            c0322a.ejP.startLoad(portrait, 28, false);
            c0322a.ejP.setIsBigV(true);
            c0322a.ejP.setShowV(true);
            c0322a.euj.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0322a.gav.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0322a.gav.setText(UtilHelper.getFixedBarText(this.mContext.getString(R.string.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0322a.gav.setVisibility(8);
                    break;
            }
            c0322a.gaw.setText(aq.aO(item.getFansNum()) + this.mContext.getString(R.string.fans_default_name) + " " + aq.aO(item.getLikeNum()) + this.mContext.getString(R.string.zan));
        }
        if (i == getCount() - 1) {
            c0322a.ein.setVisibility(8);
        } else {
            c0322a.ein.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0322a.fpl.setTag(item);
            c0322a.fpl.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0322a c0322a) {
        if (c0322a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0322a.mSkinType != skinType) {
                am.j(c0322a.euj, R.color.cp_cont_h);
                am.j(c0322a.gav, R.color.cp_cont_d);
                am.j(c0322a.gaw, R.color.cp_cont_d);
                am.l(c0322a.ein, R.color.cp_bg_line_b);
            }
            c0322a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            am.f(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.f(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        am.k(textView, R.drawable.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0322a {
        public View ein;
        public ClickableHeaderImageView ejP;
        public TextView euj;
        public TextView fpl;
        public TextView gav;
        public TextView gaw;
        public int mSkinType;

        private C0322a() {
            this.mSkinType = 3;
        }
    }
}
