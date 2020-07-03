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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bu flT;
    private String fqb;
    private i ftC;
    private a fvZ;
    private boolean fwa;
    View.OnClickListener fwb;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fwa = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.flT != null && c.this.flT.aSJ() != null && c.this.ftC != null) {
                        c.this.ftC.a(c.this.tabId, c.this.fqb, c.this.flT);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.fwb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.flT != null && c.this.flT.aSp() != null && !StringUtils.isNull(c.this.flT.aSp().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.flT.aSp().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.flT.aSp().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fvZ = new a(getView());
        this.fwa = z;
    }

    public void c(i iVar) {
        this.ftC = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fvZ.fwg, R.drawable.addresslist_item_bg);
            an.setViewTextColor(this.fvZ.fwf, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fvZ.aIn, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fvZ.fwi, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fvZ.fwj, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.flT == null || cVar.flT.aSJ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.flT = cVar.flT;
        this.tabId = cVar.tabId;
        this.fqb = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.fvZ.fwd.startLoad(this.flT.aSJ().cover, 10, false);
        this.fvZ.fwf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.numberUniformFormatExtra(this.flT.aSJ().audience_count)));
        this.fvZ.fwh.setData(this.flT, false);
        this.fvZ.fwi.setText(this.flT.getTitle());
        if (this.flT.aSp() != null) {
            String name_show = this.flT.aSp().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fvZ.aIn.setText(name_show);
        }
        String str = this.flT.aSJ().label_name;
        if (this.fwa && !StringUtils.isNull(str)) {
            this.fvZ.fwe.setText(str);
            this.fvZ.fwe.setVisibility(0);
        } else {
            this.fvZ.fwe.setVisibility(8);
        }
        if (cVar.flU) {
            this.fvZ.fwj.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, ar.numberUniformFormatExtra((long) (this.flT.aSJ().distance / 1000.0d))));
            this.fvZ.fwj.setVisibility(0);
        } else {
            this.fvZ.fwj.setVisibility(8);
        }
        this.fvZ.aIn.setOnClickListener(this.fwb);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aIn;
        public TbImageView fwd;
        public TextView fwe;
        public TextView fwf;
        public RelativeLayout fwg;
        public ClickableHeaderImageView fwh;
        public TextView fwi;
        public TextView fwj;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fwd = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fwe = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fwf = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fwg = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fwh = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aIn = (TextView) view.findViewById(R.id.tvUserName);
            this.fwi = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fwj = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.fwd.setDefaultErrorResource(0);
            this.fwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fwd.setDrawerType(0);
            this.fwh.setIsRound(true);
            this.fwh.setDrawBorder(true);
            this.fwh.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.fwh.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.fwh.setIsGod(false);
            this.fwh.setIsBigV(false);
            this.fwh.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwg.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fwg.setLayoutParams(layoutParams);
        }
    }
}
