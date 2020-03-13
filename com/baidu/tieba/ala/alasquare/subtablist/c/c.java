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
    private bj ejW;
    private String eod;
    private i erx;
    private a etV;
    private boolean etW;
    View.OnClickListener etX;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.etW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.ejW != null && c.this.ejW.aCH() != null && c.this.erx != null) {
                        c.this.erx.a(c.this.tabId, c.this.eod, c.this.ejW);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.etX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ejW != null && c.this.ejW.aCo() != null && !StringUtils.isNull(c.this.ejW.aCo().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.ejW.aCo().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.ejW.aCo().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.etV = new a(getView());
        this.etW = z;
    }

    public void c(i iVar) {
        this.erx = iVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.etV.euc, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.etV.eub, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etV.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etV.eue, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.etV.euf, (int) R.color.cp_cont_d);
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
        if (cVar == null || cVar.ejW == null || cVar.ejW.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejW = cVar.ejW;
        this.tabId = cVar.tabId;
        this.eod = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.etV.etZ.startLoad(this.ejW.aCH().cover, 10, false);
        this.etV.eub.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejW.aCH().audience_count)));
        this.etV.eud.setData(this.ejW, false);
        this.etV.eue.setText(this.ejW.getTitle());
        if (this.ejW.aCo() != null) {
            String name_show = this.ejW.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.etV.ahO.setText(name_show);
        }
        String str = this.ejW.aCH().label_name;
        if (this.etW && !StringUtils.isNull(str)) {
            this.etV.eua.setText(str);
            this.etV.eua.setVisibility(0);
        } else {
            this.etV.eua.setVisibility(8);
        }
        if (cVar.ejX) {
            this.etV.euf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejW.aCH().distance / 1000.0d))));
            this.etV.euf.setVisibility(0);
        } else {
            this.etV.euf.setVisibility(8);
        }
        this.etV.ahO.setOnClickListener(this.etX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahO;
        public TbImageView etZ;
        public TextView eua;
        public TextView eub;
        public RelativeLayout euc;
        public ClickableHeaderImageView eud;
        public TextView eue;
        public TextView euf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eua = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eub = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eud = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.eue = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.euf = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.etZ.setDefaultErrorResource(0);
            this.etZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etZ.setDrawerType(0);
            this.eud.setIsRound(true);
            this.eud.setDrawBorder(true);
            this.eud.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eud.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eud.setIsGod(false);
            this.eud.setIsBigV(false);
            this.eud.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.euc.setLayoutParams(layoutParams);
        }
    }
}
