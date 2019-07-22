package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId XE;
    private int ds94;
    public ImageView glb;
    private LinearLayout glc;
    private TextView gld;
    private ImageView gle;
    private int glf;
    private TextView mInfo;
    private TextView mTitle;

    public ConcernUnreadTipView(Context context) {
        super(context);
        init(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.ds94 = l.g(getContext(), R.dimen.tbds94);
        this.glf = 0 - l.g(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.glb = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.glc = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.gld = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.gle = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.g(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.XE = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.glb.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.bxb()) {
                setVisibility(8);
                return;
            }
            if (eVar.gkB > 0) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.gkB);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.gkC)) {
                this.mInfo.setText(eVar.gkC);
            }
            if (this.glc != null && eVar.gkA != null) {
                this.glc.removeAllViews();
                List<String> list = eVar.gkA;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.glf;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        am.c((ImageView) frameLayout.findViewById(R.id.out_img), (int) R.drawable.bg_unread_tip_head_border);
                        this.glc.addView(frameLayout);
                        headImageView.setPageId(this.XE);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.mTitle, R.color.cp_cont_b);
        am.c(this.glb, (int) R.drawable.icon_home_card_delete);
        am.j(this.mInfo, R.color.cp_cont_b);
        am.j(this.gld, R.color.cp_cont_d);
        am.c(this.gle, (int) R.drawable.icon_arrow_gray_right_n);
    }
}
