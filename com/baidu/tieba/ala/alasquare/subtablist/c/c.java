package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.View;
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
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.a.c> {
    private bj eNM;
    private String eRS;
    private i eVp;
    private a eXM;
    private boolean eXN;
    View.OnClickListener eXO;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.eNM != null && c.this.eNM.aKX() != null && c.this.eVp != null) {
                        c.this.eVp.a(c.this.tabId, c.this.eRS, c.this.eNM);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.eXO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eNM != null && c.this.eNM.aKE() != null && !StringUtils.isNull(c.this.eNM.aKE().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.eNM.aKE().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.eNM.aKE().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eXM = new a(getView());
        this.eXN = z;
    }

    public void c(i iVar) {
        this.eVp = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eXM.eXT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eXM.eXS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eXM.aAs, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eXM.eXV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eXM.eXW, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.eNM == null || cVar.eNM.aKX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNM = cVar.eNM;
        this.tabId = cVar.tabId;
        this.eRS = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eXM.eXQ.startLoad(this.eNM.aKX().cover, 10, false);
        this.eXM.eXS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNM.aKX().audience_count)));
        this.eXM.eXU.setData(this.eNM, false);
        this.eXM.eXV.setText(this.eNM.getTitle());
        if (this.eNM.aKE() != null) {
            String name_show = this.eNM.aKE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eXM.aAs.setText(name_show);
        }
        String str = this.eNM.aKX().label_name;
        if (this.eXN && !StringUtils.isNull(str)) {
            this.eXM.eXR.setText(str);
            this.eXM.eXR.setVisibility(0);
        } else {
            this.eXM.eXR.setVisibility(8);
        }
        if (cVar.eNN) {
            this.eXM.eXW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eNM.aKX().distance / 1000.0d))));
            this.eXM.eXW.setVisibility(0);
        } else {
            this.eXM.eXW.setVisibility(8);
        }
        this.eXM.aAs.setOnClickListener(this.eXO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aAs;
        public TbImageView eXQ;
        public TextView eXR;
        public TextView eXS;
        public RelativeLayout eXT;
        public ClickableHeaderImageView eXU;
        public TextView eXV;
        public TextView eXW;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAs = (TextView) view.findViewById(R.id.tvUserName);
            this.eXV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eXW = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.eXQ.setDefaultErrorResource(0);
            this.eXQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXQ.setDrawerType(0);
            this.eXU.setIsRound(true);
            this.eXU.setDrawBorder(true);
            this.eXU.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eXU.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eXU.setIsGod(false);
            this.eXU.setIsBigV(false);
            this.eXU.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eXT.setLayoutParams(layoutParams);
        }
    }
}
