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
    private bj eNR;
    private String eRX;
    private i eVu;
    private a eXR;
    private boolean eXS;
    View.OnClickListener eXT;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXS = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.eNR != null && c.this.eNR.aKV() != null && c.this.eVu != null) {
                        c.this.eVu.a(c.this.tabId, c.this.eRX, c.this.eNR);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.eXT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eNR != null && c.this.eNR.aKC() != null && !StringUtils.isNull(c.this.eNR.aKC().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.eNR.aKC().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.eNR.aKC().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eXR = new a(getView());
        this.eXS = z;
    }

    public void c(i iVar) {
        this.eVu = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eXR.eXY, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eXR.eXX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eXR.aAy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eXR.eYa, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eXR.eYb, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.eNR == null || cVar.eNR.aKV() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNR = cVar.eNR;
        this.tabId = cVar.tabId;
        this.eRX = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eXR.eXV.startLoad(this.eNR.aKV().cover, 10, false);
        this.eXR.eXX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNR.aKV().audience_count)));
        this.eXR.eXZ.setData(this.eNR, false);
        this.eXR.eYa.setText(this.eNR.getTitle());
        if (this.eNR.aKC() != null) {
            String name_show = this.eNR.aKC().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eXR.aAy.setText(name_show);
        }
        String str = this.eNR.aKV().label_name;
        if (this.eXS && !StringUtils.isNull(str)) {
            this.eXR.eXW.setText(str);
            this.eXR.eXW.setVisibility(0);
        } else {
            this.eXR.eXW.setVisibility(8);
        }
        if (cVar.eNS) {
            this.eXR.eYb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eNR.aKV().distance / 1000.0d))));
            this.eXR.eYb.setVisibility(0);
        } else {
            this.eXR.eYb.setVisibility(8);
        }
        this.eXR.aAy.setOnClickListener(this.eXT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView aAy;
        public TbImageView eXV;
        public TextView eXW;
        public TextView eXX;
        public RelativeLayout eXY;
        public ClickableHeaderImageView eXZ;
        public TextView eYa;
        public TextView eYb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXV = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXW = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXX = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXY = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXZ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAy = (TextView) view.findViewById(R.id.tvUserName);
            this.eYa = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eYb = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.eXV.setDefaultErrorResource(0);
            this.eXV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXV.setDrawerType(0);
            this.eXZ.setIsRound(true);
            this.eXZ.setDrawBorder(true);
            this.eXZ.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eXZ.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eXZ.setIsGod(false);
            this.eXZ.setIsBigV(false);
            this.eXZ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eXY.setLayoutParams(layoutParams);
        }
    }
}
