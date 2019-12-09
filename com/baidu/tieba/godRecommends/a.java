package com.baidu.tieba.godRecommends;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
        if (!v.isEmpty(list)) {
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
    /* renamed from: sz */
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
        C0417a c0417a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.god_recommend_list_item, (ViewGroup) null);
            C0417a c0417a2 = new C0417a();
            c0417a2.gaR = (ClickableHeaderImageView) view.findViewById(R.id.photo);
            c0417a2.evA = (TextView) view.findViewById(R.id.user_name);
            c0417a2.gaS = (TextView) view.findViewById(R.id.god_info);
            c0417a2.gaT = (TextView) view.findViewById(R.id.fans_and_thread_count);
            c0417a2.gaU = (TextView) view.findViewById(R.id.attention_btn);
            c0417a2.eMN = view.findViewById(R.id.bottom_line);
            view.setTag(c0417a2);
            c0417a = c0417a2;
        } else {
            c0417a = (C0417a) view.getTag();
        }
        a(c0417a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0417a.gaU, item.getGodUserData().getIsLike());
            c0417a.gaR.setGodIconMargin(0);
            c0417a.gaR.setClickable(false);
            c0417a.gaR.startLoad(portrait, 28, false);
            c0417a.gaR.setIsBigV(true);
            c0417a.gaR.setShowV(true);
            c0417a.evA.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0417a.gaS.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0417a.gaS.setText(UtilHelper.getFixedBarText(this.mContext.getString(R.string.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0417a.gaS.setVisibility(8);
                    break;
            }
            c0417a.gaT.setText(aq.numFormatOverWan(item.getFansNum()) + this.mContext.getString(R.string.fans_default_name) + HanziToPinyin.Token.SEPARATOR + aq.numFormatOverWan(item.getLikeNum()) + this.mContext.getString(R.string.zan));
        }
        if (i == getCount() - 1) {
            c0417a.eMN.setVisibility(8);
        } else {
            c0417a.eMN.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0417a.gaU.setTag(item);
            c0417a.gaU.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0417a c0417a) {
        if (c0417a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0417a.mSkinType != skinType) {
                am.setViewTextColor(c0417a.evA, (int) R.color.cp_cont_h);
                am.setViewTextColor(c0417a.gaS, (int) R.color.cp_cont_d);
                am.setViewTextColor(c0417a.gaT, (int) R.color.cp_cont_d);
                am.setBackgroundColor(c0417a.eMN, R.color.cp_bg_line_c);
            }
            c0417a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            am.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        am.setBackgroundResource(textView, R.drawable.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0417a {
        public View eMN;
        public TextView evA;
        public ClickableHeaderImageView gaR;
        public TextView gaS;
        public TextView gaT;
        public TextView gaU;
        public int mSkinType;

        private C0417a() {
            this.mSkinType = 3;
        }
    }
}
