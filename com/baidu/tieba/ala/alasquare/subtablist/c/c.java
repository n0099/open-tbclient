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
    private bj ejI;
    private String enP;
    private i eri;
    private a etH;
    private boolean etI;
    View.OnClickListener etJ;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.etI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.ejI != null && c.this.ejI.aCF() != null && c.this.eri != null) {
                        c.this.eri.a(c.this.tabId, c.this.enP, c.this.ejI);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.etJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ejI != null && c.this.ejI.aCm() != null && !StringUtils.isNull(c.this.ejI.aCm().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.ejI.aCm().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.ejI.aCm().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.etH = new a(getView());
        this.etI = z;
    }

    public void c(i iVar) {
        this.eri = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.etH.etO, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.etH.etN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etH.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etH.etQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.etH.etR, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.ejI == null || cVar.ejI.aCF() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejI = cVar.ejI;
        this.tabId = cVar.tabId;
        this.enP = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.etH.etL.startLoad(this.ejI.aCF().cover, 10, false);
        this.etH.etN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejI.aCF().audience_count)));
        this.etH.etP.setData(this.ejI, false);
        this.etH.etQ.setText(this.ejI.getTitle());
        if (this.ejI.aCm() != null) {
            String name_show = this.ejI.aCm().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.etH.ahO.setText(name_show);
        }
        String str = this.ejI.aCF().label_name;
        if (this.etI && !StringUtils.isNull(str)) {
            this.etH.etM.setText(str);
            this.etH.etM.setVisibility(0);
        } else {
            this.etH.etM.setVisibility(8);
        }
        if (cVar.ejJ) {
            this.etH.etR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejI.aCF().distance / 1000.0d))));
            this.etH.etR.setVisibility(0);
        } else {
            this.etH.etR.setVisibility(8);
        }
        this.etH.ahO.setOnClickListener(this.etJ);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahO;
        public TbImageView etL;
        public TextView etM;
        public TextView etN;
        public RelativeLayout etO;
        public ClickableHeaderImageView etP;
        public TextView etQ;
        public TextView etR;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etL = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.etM = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.etN = (TextView) view.findViewById(R.id.tvLiveCount);
            this.etO = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.etP = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.etQ = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.etR = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.etL.setDefaultErrorResource(0);
            this.etL.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etL.setDrawerType(0);
            this.etP.setIsRound(true);
            this.etP.setDrawBorder(true);
            this.etP.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.etP.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.etP.setIsGod(false);
            this.etP.setIsBigV(false);
            this.etP.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etO.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.etO.setLayoutParams(layoutParams);
        }
    }
}
