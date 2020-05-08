package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {
    private bj eNR;
    private String eRX;
    private i eVu;
    private boolean eXS;
    private a eYv;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.eNR != null && g.this.eNR.aKV() != null && g.this.eVu != null) {
                    g.this.eVu.a(g.this.tabId, g.this.eRX, g.this.eNR);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener eXT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.eNR != null && g.this.eNR.aKC() != null && !StringUtils.isNull(g.this.eNR.aKC().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.eNR.aKC().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.eNR.aKC().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eYv = new a(this.mRootView);
        this.eXS = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.eVu = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.eNR == null || cVar.eNR.aKV() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNR = cVar.eNR;
        this.tabId = cVar.tabId;
        this.eRX = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eYv.eXV.setDrawerType(0);
        this.eYv.eXV.setBorderSurroundContent(true);
        this.eYv.eXV.setDrawBorder(true);
        this.eYv.eXV.startLoad(this.eNR.aKV().cover, 10, false);
        this.eYv.eXX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNR.aKV().audience_count)));
        this.eYv.eXZ.setData(this.eNR, false);
        this.eYv.eYa.setText(this.eNR.getTitle());
        if (this.eNR.aKC() != null) {
            String name_show = this.eNR.aKC().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eYv.aAy.setText(name_show);
        }
        String str = this.eNR.aKV().label_name;
        if (this.eXS && !StringUtils.isNull(str)) {
            this.eYv.eXW.setText(str);
            this.eYv.eXW.setVisibility(0);
        } else {
            this.eYv.eXW.setVisibility(8);
        }
        if (cVar.eNS) {
            this.eYv.eYb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eNR.aKV().distance / 1000.0d))));
            this.eYv.eYb.setVisibility(0);
        } else {
            this.eYv.eYb.setVisibility(8);
        }
        this.eYv.aAy.setOnClickListener(this.eXT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eYv.eXY, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eYv.eXX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eYv.aAy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eYv.eYa, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eYv.eYb, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aAy;
        public TbImageView eXV;
        public TextView eXW;
        public TextView eXX;
        public RelativeLayout eXY;
        public ClickableHeaderImageView eXZ;
        public TextView eYa;
        public TextView eYb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXV = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXW = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXX = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXY = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXZ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAy = (TextView) view.findViewById(R.id.tvUserName);
            this.eYa = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eYb = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.eXV.setDefaultErrorResource(0);
            this.eXV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXV.setDrawerType(0);
            this.eXZ.setIsRound(true);
            this.eXZ.setDrawBorder(true);
            this.eXZ.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eXZ.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eXZ.setIsGod(false);
            this.eXZ.setIsBigV(false);
            this.eXZ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.eXY.setLayoutParams(layoutParams);
        }
    }
}
