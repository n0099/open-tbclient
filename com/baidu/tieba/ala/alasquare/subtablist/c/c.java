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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bx ghv;
    private String glK;
    private i gpj;
    private a grG;
    private boolean grH;
    View.OnClickListener grI;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.grH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.ghv != null && c.this.ghv.blW() != null && c.this.gpj != null) {
                        c.this.gpj.a(c.this.tabId, c.this.glK, c.this.ghv);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.grI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ghv != null && c.this.ghv.blC() != null && !StringUtils.isNull(c.this.ghv.blC().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.ghv.blC().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.ghv.blC().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.grG = new a(getView());
        this.grH = z;
    }

    public void c(i iVar) {
        this.gpj = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.grG.grN, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.grG.grM, R.color.CAM_X0101);
            ap.setViewTextColor(this.grG.aVl, R.color.CAM_X0101);
            ap.setViewTextColor(this.grG.grP, R.color.CAM_X0105);
            ap.setViewTextColor(this.grG.grQ, R.color.CAM_X0109);
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
        if (cVar == null || cVar.ghv == null || cVar.ghv.blW() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ghv = cVar.ghv;
        this.tabId = cVar.tabId;
        this.glK = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.grG.grK.startLoad(this.ghv.blW().cover, 10, false);
        this.grG.grM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.ghv.blW().audience_count)));
        this.grG.grO.setData(this.ghv, false);
        this.grG.grP.setText(this.ghv.getTitle());
        if (this.ghv.blC() != null) {
            String name_show = this.ghv.blC().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.grG.aVl.setText(name_show);
        }
        String str = this.ghv.blW().label_name;
        if (this.grH && !StringUtils.isNull(str)) {
            this.grG.grL.setText(str);
            this.grG.grL.setVisibility(0);
        } else {
            this.grG.grL.setVisibility(8);
        }
        if (cVar.ghw) {
            this.grG.grQ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.ghv.blW().distance / 1000.0d))));
            this.grG.grQ.setVisibility(0);
        } else {
            this.grG.grQ.setVisibility(8);
        }
        this.grG.aVl.setOnClickListener(this.grI);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aVl;
        public TbImageView grK;
        public TextView grL;
        public TextView grM;
        public RelativeLayout grN;
        public ClickableHeaderImageView grO;
        public TextView grP;
        public TextView grQ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.grK = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.grL = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.grM = (TextView) view.findViewById(R.id.tvLiveCount);
            this.grN = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.grO = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVl = (TextView) view.findViewById(R.id.tvUserName);
            this.grP = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.grQ = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.grK.setDefaultErrorResource(0);
            this.grK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.grK.setDrawerType(0);
            this.grO.setIsRound(true);
            this.grO.setDrawBorder(true);
            this.grO.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.grO.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.grO.setIsGod(false);
            this.grO.setIsBigV(false);
            this.grO.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grN.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.grN.setLayoutParams(layoutParams);
        }
    }
}
