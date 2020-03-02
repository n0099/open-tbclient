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
    private bj ejJ;
    private String enQ;
    private i erj;
    private a etI;
    private boolean etJ;
    View.OnClickListener etK;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.etJ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.ejJ != null && c.this.ejJ.aCH() != null && c.this.erj != null) {
                        c.this.erj.a(c.this.tabId, c.this.enQ, c.this.ejJ);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.etK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ejJ != null && c.this.ejJ.aCo() != null && !StringUtils.isNull(c.this.ejJ.aCo().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.ejJ.aCo().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.ejJ.aCo().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.etI = new a(getView());
        this.etJ = z;
    }

    public void c(i iVar) {
        this.erj = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.etI.etP, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.etI.etO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etI.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etI.etR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.etI.etS, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.ejJ == null || cVar.ejJ.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejJ = cVar.ejJ;
        this.tabId = cVar.tabId;
        this.enQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.etI.etM.startLoad(this.ejJ.aCH().cover, 10, false);
        this.etI.etO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejJ.aCH().audience_count)));
        this.etI.etQ.setData(this.ejJ, false);
        this.etI.etR.setText(this.ejJ.getTitle());
        if (this.ejJ.aCo() != null) {
            String name_show = this.ejJ.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.etI.ahO.setText(name_show);
        }
        String str = this.ejJ.aCH().label_name;
        if (this.etJ && !StringUtils.isNull(str)) {
            this.etI.etN.setText(str);
            this.etI.etN.setVisibility(0);
        } else {
            this.etI.etN.setVisibility(8);
        }
        if (cVar.ejK) {
            this.etI.etS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejJ.aCH().distance / 1000.0d))));
            this.etI.etS.setVisibility(0);
        } else {
            this.etI.etS.setVisibility(8);
        }
        this.etI.ahO.setOnClickListener(this.etK);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahO;
        public TbImageView etM;
        public TextView etN;
        public TextView etO;
        public RelativeLayout etP;
        public ClickableHeaderImageView etQ;
        public TextView etR;
        public TextView etS;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etM = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.etN = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.etO = (TextView) view.findViewById(R.id.tvLiveCount);
            this.etP = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.etQ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.etR = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.etS = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.etM.setDefaultErrorResource(0);
            this.etM.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etM.setDrawerType(0);
            this.etQ.setIsRound(true);
            this.etQ.setDrawBorder(true);
            this.etQ.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.etQ.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.etQ.setIsGod(false);
            this.etQ.setIsBigV(false);
            this.etQ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etP.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.etP.setLayoutParams(layoutParams);
        }
    }
}
