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
    /* renamed from: th */
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
        C0319a c0319a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.god_recommend_list_item, (ViewGroup) null);
            C0319a c0319a2 = new C0319a();
            c0319a2.efd = (ClickableHeaderImageView) view.findViewById(R.id.photo);
            c0319a2.epd = (TextView) view.findViewById(R.id.user_name);
            c0319a2.fUF = (TextView) view.findViewById(R.id.god_info);
            c0319a2.fUG = (TextView) view.findViewById(R.id.fans_and_thread_count);
            c0319a2.fjO = (TextView) view.findViewById(R.id.attention_btn);
            c0319a2.edD = view.findViewById(R.id.bottom_line);
            view.setTag(c0319a2);
            c0319a = c0319a2;
        } else {
            c0319a = (C0319a) view.getTag();
        }
        a(c0319a);
        MetaData item = getItem(i);
        if (item != null) {
            String portrait = item.getPortrait();
            d(c0319a.fjO, item.getGodUserData().getIsLike());
            c0319a.efd.setGodIconMargin(0);
            c0319a.efd.setClickable(false);
            c0319a.efd.startLoad(portrait, 28, false);
            c0319a.efd.setIsBigV(true);
            c0319a.efd.setShowV(true);
            c0319a.epd.setText(item.getName_show());
            switch (item.getGodUserData().getType()) {
                case 1:
                    c0319a.fUF.setText(UtilHelper.getFixedBarText(item.getGodUserData().getIntro(), 10, true, true));
                    break;
                case 2:
                    c0319a.fUF.setText(UtilHelper.getFixedBarText(this.mContext.getString(R.string.chosen_pb_original_god_bar, item.getGodUserData().getForumName()), 10, true, true));
                    break;
                default:
                    c0319a.fUF.setVisibility(8);
                    break;
            }
            c0319a.fUG.setText(ap.aN(item.getFansNum()) + this.mContext.getString(R.string.fans_default_name) + " " + ap.aN(item.getLikeNum()) + this.mContext.getString(R.string.zan));
        }
        if (i == getCount() - 1) {
            c0319a.edD.setVisibility(8);
        } else {
            c0319a.edD.setVisibility(0);
        }
        if (this.mOnClickListener != null && item != null) {
            c0319a.fjO.setTag(item);
            c0319a.fjO.setOnClickListener(this.mOnClickListener);
        }
        return view;
    }

    private void a(C0319a c0319a) {
        if (c0319a != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (c0319a.mSkinType != skinType) {
                al.j(c0319a.epd, R.color.cp_cont_h);
                al.j(c0319a.fUF, R.color.cp_cont_d);
                al.j(c0319a.fUG, R.color.cp_cont_d);
                al.l(c0319a.edD, R.color.cp_bg_line_b);
            }
            c0319a.mSkinType = skinType;
        }
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            al.f(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.f(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        al.k(textView, R.drawable.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.godRecommends.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0319a {
        public View edD;
        public ClickableHeaderImageView efd;
        public TextView epd;
        public TextView fUF;
        public TextView fUG;
        public TextView fjO;
        public int mSkinType;

        private C0319a() {
            this.mSkinType = 3;
        }
    }
}
