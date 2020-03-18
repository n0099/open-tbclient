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
    private bj ekm;
    private String eov;
    private i erT;
    private a eur;
    private boolean eus;
    View.OnClickListener eut;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eus = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.ekm != null && c.this.ekm.aCK() != null && c.this.erT != null) {
                        c.this.erT.a(c.this.tabId, c.this.eov, c.this.ekm);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.eut = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ekm != null && c.this.ekm.aCr() != null && !StringUtils.isNull(c.this.ekm.aCr().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.ekm.aCr().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.ekm.aCr().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eur = new a(getView());
        this.eus = z;
    }

    public void c(i iVar) {
        this.erT = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eur.euy, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eur.eux, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eur.ahY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eur.euA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eur.euB, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.ekm == null || cVar.ekm.aCK() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ekm = cVar.ekm;
        this.tabId = cVar.tabId;
        this.eov = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eur.euv.startLoad(this.ekm.aCK().cover, 10, false);
        this.eur.eux.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ekm.aCK().audience_count)));
        this.eur.euz.setData(this.ekm, false);
        this.eur.euA.setText(this.ekm.getTitle());
        if (this.ekm.aCr() != null) {
            String name_show = this.ekm.aCr().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eur.ahY.setText(name_show);
        }
        String str = this.ekm.aCK().label_name;
        if (this.eus && !StringUtils.isNull(str)) {
            this.eur.euw.setText(str);
            this.eur.euw.setVisibility(0);
        } else {
            this.eur.euw.setVisibility(8);
        }
        if (cVar.ekn) {
            this.eur.euB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ekm.aCK().distance / 1000.0d))));
            this.eur.euB.setVisibility(0);
        } else {
            this.eur.euB.setVisibility(8);
        }
        this.eur.ahY.setOnClickListener(this.eut);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahY;
        public TextView euA;
        public TextView euB;
        public TbImageView euv;
        public TextView euw;
        public TextView eux;
        public RelativeLayout euy;
        public ClickableHeaderImageView euz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.euv = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.euw = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eux = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euy = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.euz = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahY = (TextView) view.findViewById(R.id.tvUserName);
            this.euA = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.euB = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.euv.setDefaultErrorResource(0);
            this.euv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.euv.setDrawerType(0);
            this.euz.setIsRound(true);
            this.euz.setDrawBorder(true);
            this.euz.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.euz.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.euz.setIsGod(false);
            this.euz.setIsBigV(false);
            this.euz.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euy.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.euy.setLayoutParams(layoutParams);
        }
    }
}
