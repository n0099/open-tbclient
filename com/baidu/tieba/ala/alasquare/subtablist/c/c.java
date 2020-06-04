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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bk faJ;
    private String feQ;
    private i fio;
    private a fkM;
    private boolean fkN;
    View.OnClickListener fkO;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fkN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.faJ != null && c.this.faJ.aQS() != null && c.this.fio != null) {
                        c.this.fio.a(c.this.tabId, c.this.feQ, c.this.faJ);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fkO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.faJ != null && c.this.faJ.aQx() != null && !StringUtils.isNull(c.this.faJ.aQx().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.faJ.aQx().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.faJ.aQx().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fkM = new a(getView());
        this.fkN = z;
    }

    public void c(i iVar) {
        this.fio = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fkM.fkT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fkM.fkS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fkM.aFR, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fkM.fkV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fkM.fkW, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.faJ == null || cVar.faJ.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.faJ = cVar.faJ;
        this.tabId = cVar.tabId;
        this.feQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fkM.fkQ.startLoad(this.faJ.aQS().cover, 10, false);
        this.fkM.fkS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.faJ.aQS().audience_count)));
        this.fkM.fkU.setData(this.faJ, false);
        this.fkM.fkV.setText(this.faJ.getTitle());
        if (this.faJ.aQx() != null) {
            String name_show = this.faJ.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fkM.aFR.setText(name_show);
        }
        String str = this.faJ.aQS().label_name;
        if (this.fkN && !StringUtils.isNull(str)) {
            this.fkM.fkR.setText(str);
            this.fkM.fkR.setVisibility(0);
        } else {
            this.fkM.fkR.setVisibility(8);
        }
        if (cVar.faK) {
            this.fkM.fkW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.faJ.aQS().distance / 1000.0d))));
            this.fkM.fkW.setVisibility(0);
        } else {
            this.fkM.fkW.setVisibility(8);
        }
        this.fkM.aFR.setOnClickListener(this.fkO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aFR;
        public TbImageView fkQ;
        public TextView fkR;
        public TextView fkS;
        public RelativeLayout fkT;
        public ClickableHeaderImageView fkU;
        public TextView fkV;
        public TextView fkW;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fkV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fkW = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fkQ.setDefaultErrorResource(0);
            this.fkQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkQ.setDrawerType(0);
            this.fkU.setIsRound(true);
            this.fkU.setDrawBorder(true);
            this.fkU.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fkU.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fkU.setIsGod(false);
            this.fkU.setIsBigV(false);
            this.fkU.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fkT.setLayoutParams(layoutParams);
        }
    }
}
