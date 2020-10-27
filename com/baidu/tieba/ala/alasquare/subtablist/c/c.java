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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bw gbZ;
    private String ggp;
    private i gjP;
    private a gmm;
    private boolean gmn;
    View.OnClickListener gmo;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gmn = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.gbZ != null && c.this.gbZ.bku() != null && c.this.gjP != null) {
                        c.this.gjP.a(c.this.tabId, c.this.ggp, c.this.gbZ);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gmo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gbZ != null && c.this.gbZ.bka() != null && !StringUtils.isNull(c.this.gbZ.bka().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.gbZ.bka().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.gbZ.bka().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gmm = new a(getView());
        this.gmn = z;
    }

    public void c(i iVar) {
        this.gjP = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmm.gmt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gmm.gms, R.color.cp_cont_a);
            ap.setViewTextColor(this.gmm.aVE, R.color.cp_cont_a);
            ap.setViewTextColor(this.gmm.gmv, R.color.cp_cont_b);
            ap.setViewTextColor(this.gmm.gmw, R.color.cp_cont_d);
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
        if (cVar == null || cVar.gbZ == null || cVar.gbZ.bku() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gbZ = cVar.gbZ;
        this.tabId = cVar.tabId;
        this.ggp = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gmm.gmq.startLoad(this.gbZ.bku().cover, 10, false);
        this.gmm.gms.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gbZ.bku().audience_count)));
        this.gmm.gmu.setData(this.gbZ, false);
        this.gmm.gmv.setText(this.gbZ.getTitle());
        if (this.gbZ.bka() != null) {
            String name_show = this.gbZ.bka().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gmm.aVE.setText(name_show);
        }
        String str = this.gbZ.bku().label_name;
        if (this.gmn && !StringUtils.isNull(str)) {
            this.gmm.gmr.setText(str);
            this.gmm.gmr.setVisibility(0);
        } else {
            this.gmm.gmr.setVisibility(8);
        }
        if (cVar.gca) {
            this.gmm.gmw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gbZ.bku().distance / 1000.0d))));
            this.gmm.gmw.setVisibility(0);
        } else {
            this.gmm.gmw.setVisibility(8);
        }
        this.gmm.aVE.setOnClickListener(this.gmo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aVE;
        public TbImageView gmq;
        public TextView gmr;
        public TextView gms;
        public RelativeLayout gmt;
        public ClickableHeaderImageView gmu;
        public TextView gmv;
        public TextView gmw;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gmq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gmr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gms = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gmt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gmu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVE = (TextView) view.findViewById(R.id.tvUserName);
            this.gmv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gmw = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.gmq.setDefaultErrorResource(0);
            this.gmq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gmq.setDrawerType(0);
            this.gmu.setIsRound(true);
            this.gmu.setDrawBorder(true);
            this.gmu.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gmu.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gmu.setIsGod(false);
            this.gmu.setIsBigV(false);
            this.gmu.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gmt.setLayoutParams(layoutParams);
        }
    }
}
