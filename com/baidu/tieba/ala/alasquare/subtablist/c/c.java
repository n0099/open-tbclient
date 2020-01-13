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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.a.c> {
    private bj efE;
    private String ejF;
    private i emV;
    private a epw;
    private boolean epx;
    View.OnClickListener epy;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.epx = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.efE != null && c.this.efE.aAq() != null && c.this.emV != null) {
                        c.this.emV.a(c.this.tabId, c.this.ejF, c.this.efE);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.epy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.efE != null && c.this.efE.azX() != null && !StringUtils.isNull(c.this.efE.azX().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.efE.azX().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.efE.azX().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.epw = new a(getView());
        this.epx = z;
    }

    public void c(i iVar) {
        this.emV = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.epw.epD, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.epw.epC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.epw.afG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.epw.epF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.epw.epG, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.efE == null || cVar.efE.aAq() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.efE = cVar.efE;
        this.tabId = cVar.tabId;
        this.ejF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.epw.epA.startLoad(this.efE.aAq().cover, 10, false);
        this.epw.epC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.efE.aAq().audience_count)));
        this.epw.epE.setData(this.efE, false);
        this.epw.epF.setText(this.efE.getTitle());
        if (this.efE.azX() != null) {
            String name_show = this.efE.azX().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.epw.afG.setText(name_show);
        }
        String str = this.efE.aAq().label_name;
        if (this.epx && !StringUtils.isNull(str)) {
            this.epw.epB.setText(str);
            this.epw.epB.setVisibility(0);
        } else {
            this.epw.epB.setVisibility(8);
        }
        if (cVar.efF) {
            this.epw.epG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.efE.aAq().distance / 1000.0d))));
            this.epw.epG.setVisibility(0);
        } else {
            this.epw.epG.setVisibility(8);
        }
        this.epw.afG.setOnClickListener(this.epy);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView afG;
        public TbImageView epA;
        public TextView epB;
        public TextView epC;
        public RelativeLayout epD;
        public ClickableHeaderImageView epE;
        public TextView epF;
        public TextView epG;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.epA = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.epB = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.epC = (TextView) view.findViewById(R.id.tvLiveCount);
            this.epD = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.epE = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.afG = (TextView) view.findViewById(R.id.tvUserName);
            this.epF = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.epG = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.epA.setDefaultErrorResource(0);
            this.epA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.epA.setDrawerType(0);
            this.epE.setIsRound(true);
            this.epE.setDrawBorder(true);
            this.epE.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.epE.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.epE.setIsGod(false);
            this.epE.setIsBigV(false);
            this.epE.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epD.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.epD.setLayoutParams(layoutParams);
        }
    }
}
