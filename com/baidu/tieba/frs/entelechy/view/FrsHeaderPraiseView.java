package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    private View fFL;
    private View fFM;
    private TextView fFN;
    private FrameLayout fFO;
    private ImageView fFP;

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.frs_header_extra_praise_layout, this);
        initView();
    }

    private void initView() {
        this.fFL = findViewById(R.id.divider_top);
        this.fFM = findViewById(R.id.divider_bottom);
        this.fFN = (TextView) findViewById(R.id.frs_praise_title);
        this.fFO = (FrameLayout) findViewById(R.id.frs_praise_portrait);
        this.fFP = (ImageView) findViewById(R.id.frs_praise_more);
        am.setImageResource(this.fFP, R.drawable.icon_arrow_more_gray_n);
    }

    public void setData(final AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fFN.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.fFO.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.fFO.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds40), getResources().getDimensionPixelSize(R.dimen.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                headImageView.setDefaultBgResource(R.color.cp_bg_line_e);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(am.getColor(R.color.cp_bg_line_d));
                headImageView.setBorderWidth(l.getDimens(getContext(), R.dimen.ds2));
                headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds8));
                }
                layoutParams.gravity = 5;
                this.fFO.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(agreeBanner.url)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(FrsHeaderPraiseView.this.getContext(), null, agreeBanner.url, true)));
                }
            }
        });
    }
}
