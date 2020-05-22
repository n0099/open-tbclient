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
    private bk fay;
    private String feF;
    private i fic;
    private a fkB;
    private boolean fkC;
    View.OnClickListener fkD;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fkC = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.fay != null && c.this.fay.aQS() != null && c.this.fic != null) {
                        c.this.fic.a(c.this.tabId, c.this.feF, c.this.fay);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fkD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fay != null && c.this.fay.aQx() != null && !StringUtils.isNull(c.this.fay.aQx().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.fay.aQx().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.fay.aQx().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fkB = new a(getView());
        this.fkC = z;
    }

    public void c(i iVar) {
        this.fic = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fkB.fkI, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fkB.fkH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fkB.aFR, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fkB.fkK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fkB.fkL, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.fay == null || cVar.fay.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fay = cVar.fay;
        this.tabId = cVar.tabId;
        this.feF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fkB.fkF.startLoad(this.fay.aQS().cover, 10, false);
        this.fkB.fkH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.fay.aQS().audience_count)));
        this.fkB.fkJ.setData(this.fay, false);
        this.fkB.fkK.setText(this.fay.getTitle());
        if (this.fay.aQx() != null) {
            String name_show = this.fay.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fkB.aFR.setText(name_show);
        }
        String str = this.fay.aQS().label_name;
        if (this.fkC && !StringUtils.isNull(str)) {
            this.fkB.fkG.setText(str);
            this.fkB.fkG.setVisibility(0);
        } else {
            this.fkB.fkG.setVisibility(8);
        }
        if (cVar.faz) {
            this.fkB.fkL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.fay.aQS().distance / 1000.0d))));
            this.fkB.fkL.setVisibility(0);
        } else {
            this.fkB.fkL.setVisibility(8);
        }
        this.fkB.aFR.setOnClickListener(this.fkD);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aFR;
        public TbImageView fkF;
        public TextView fkG;
        public TextView fkH;
        public RelativeLayout fkI;
        public ClickableHeaderImageView fkJ;
        public TextView fkK;
        public TextView fkL;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkF = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkG = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkH = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkI = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkJ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fkK = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fkL = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fkF.setDefaultErrorResource(0);
            this.fkF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkF.setDrawerType(0);
            this.fkJ.setIsRound(true);
            this.fkJ.setDrawBorder(true);
            this.fkJ.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fkJ.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fkJ.setIsGod(false);
            this.fkJ.setIsBigV(false);
            this.fkJ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkI.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fkI.setLayoutParams(layoutParams);
        }
    }
}
