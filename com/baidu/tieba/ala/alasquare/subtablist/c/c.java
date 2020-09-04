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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bw fCB;
    private String fGI;
    private i fKf;
    private a fMC;
    private boolean fMD;
    View.OnClickListener fME;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fMD = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.fCB != null && c.this.fCB.beY() != null && c.this.fKf != null) {
                        c.this.fKf.a(c.this.tabId, c.this.fGI, c.this.fCB);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fME = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fCB != null && c.this.fCB.beE() != null && !StringUtils.isNull(c.this.fCB.beE().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.fCB.beE().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.fCB.beE().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fMC = new a(getView());
        this.fMD = z;
    }

    public void c(i iVar) {
        this.fKf = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fMC.fMJ, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fMC.fMI, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fMC.aOW, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fMC.fML, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fMC.fMM, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fCB == null || cVar.fCB.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCB = cVar.fCB;
        this.tabId = cVar.tabId;
        this.fGI = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fMC.fMG.startLoad(this.fCB.beY().cover, 10, false);
        this.fMC.fMI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCB.beY().audience_count)));
        this.fMC.fMK.setData(this.fCB, false);
        this.fMC.fML.setText(this.fCB.getTitle());
        if (this.fCB.beE() != null) {
            String name_show = this.fCB.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fMC.aOW.setText(name_show);
        }
        String str = this.fCB.beY().label_name;
        if (this.fMD && !StringUtils.isNull(str)) {
            this.fMC.fMH.setText(str);
            this.fMC.fMH.setVisibility(0);
        } else {
            this.fMC.fMH.setVisibility(8);
        }
        if (cVar.fCC) {
            this.fMC.fMM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fCB.beY().distance / 1000.0d))));
            this.fMC.fMM.setVisibility(0);
        } else {
            this.fMC.fMM.setVisibility(8);
        }
        this.fMC.aOW.setOnClickListener(this.fME);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aOW;
        public TbImageView fMG;
        public TextView fMH;
        public TextView fMI;
        public RelativeLayout fMJ;
        public ClickableHeaderImageView fMK;
        public TextView fML;
        public TextView fMM;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMG = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMH = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fMI = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMJ = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMK = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOW = (TextView) view.findViewById(R.id.tvUserName);
            this.fML = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fMM = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fMG.setDefaultErrorResource(0);
            this.fMG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMG.setDrawerType(0);
            this.fMK.setIsRound(true);
            this.fMK.setDrawBorder(true);
            this.fMK.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fMK.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fMK.setIsGod(false);
            this.fMK.setIsBigV(false);
            this.fMK.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMJ.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fMJ.setLayoutParams(layoutParams);
        }
    }
}
