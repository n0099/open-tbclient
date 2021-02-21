package com.baidu.tieba.ala.alasquare.subtablist.view;

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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private String gDl;
    private g gGP;
    private a gJm;
    private boolean gJn;
    View.OnClickListener gJo;
    private cb gyO;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gJn = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (b.this.gyO != null && b.this.gyO.boj() != null && b.this.gGP != null) {
                        b.this.gGP.a(b.this.tabId, b.this.gDl, b.this.gyO);
                        return;
                    }
                    return;
                }
                l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gJo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gyO != null && b.this.gyO.bnQ() != null && !StringUtils.isNull(b.this.gyO.bnQ().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(b.this.gyO.bnQ().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.gyO.bnQ().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gJm = new a(getView());
        this.gJn = z;
    }

    public void c(g gVar) {
        this.gGP = gVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJm.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJm.gJs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJm.aYx, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJm.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gJm.gJw, R.color.CAM_X0109);
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
    public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gyO == null || eVar.gyO.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyO = eVar.gyO;
        this.tabId = eVar.tabId;
        this.gDl = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gJm.gJq.startLoad(this.gyO.boj().cover, 10, false);
        this.gJm.gJs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        this.gJm.gJu.setData(this.gyO, false);
        this.gJm.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gJm.aYx.setText(name_show);
        }
        String str = this.gyO.boj().label_name;
        if (this.gJn && !StringUtils.isNull(str)) {
            this.gJm.gJr.setText(str);
            this.gJm.gJr.setVisibility(0);
        } else {
            this.gJm.gJr.setVisibility(8);
        }
        if (eVar.gyW) {
            this.gJm.gJw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gyO.boj().distance / 1000.0d))));
            this.gJm.gJw.setVisibility(0);
        } else {
            this.gJm.gJw.setVisibility(8);
        }
        this.gJm.aYx.setOnClickListener(this.gJo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView aYx;
        public TbImageView gJq;
        public TextView gJr;
        public TextView gJs;
        public RelativeLayout gJt;
        public ClickableHeaderImageView gJu;
        public TextView gJv;
        public TextView gJw;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJs = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gJv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJw = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(b.this.mOnClickListener);
            this.gJq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJq.setDrawerType(0);
            this.gJu.setIsRound(true);
            this.gJu.setDrawBorder(true);
            this.gJu.setBorderColor(b.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gJu.setBorderWidth(b.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gJu.setIsGod(false);
            this.gJu.setIsBigV(false);
            this.gJu.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gJt.setLayoutParams(layoutParams);
        }
    }
}
