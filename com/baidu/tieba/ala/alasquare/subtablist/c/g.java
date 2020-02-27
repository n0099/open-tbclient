package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class g {
    private bj ejI;
    private String enP;
    private i eri;
    private boolean etI;
    private a eul;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ejI != null && g.this.ejI.aCF() != null && g.this.eri != null) {
                    g.this.eri.a(g.this.tabId, g.this.enP, g.this.ejI);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener etJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ejI != null && g.this.ejI.aCm() != null && !StringUtils.isNull(g.this.ejI.aCm().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ejI.aCm().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ejI.aCm().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eul = new a(this.mRootView);
        this.etI = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.eri = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ejI == null || cVar.ejI.aCF() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejI = cVar.ejI;
        this.tabId = cVar.tabId;
        this.enP = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eul.etL.setDrawerType(0);
        this.eul.etL.setBorderSurroundContent(true);
        this.eul.etL.setDrawBorder(true);
        this.eul.etL.startLoad(this.ejI.aCF().cover, 10, false);
        this.eul.etN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejI.aCF().audience_count)));
        this.eul.etP.setData(this.ejI, false);
        this.eul.etQ.setText(this.ejI.getTitle());
        if (this.ejI.aCm() != null) {
            String name_show = this.ejI.aCm().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eul.ahO.setText(name_show);
        }
        String str = this.ejI.aCF().label_name;
        if (this.etI && !StringUtils.isNull(str)) {
            this.eul.etM.setText(str);
            this.eul.etM.setVisibility(0);
        } else {
            this.eul.etM.setVisibility(8);
        }
        if (cVar.ejJ) {
            this.eul.etR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejI.aCF().distance / 1000.0d))));
            this.eul.etR.setVisibility(0);
        } else {
            this.eul.etR.setVisibility(8);
        }
        this.eul.ahO.setOnClickListener(this.etJ);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eul.etO, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eul.etN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eul.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eul.etQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eul.etR, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
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
            view.setOnClickListener(g.this.mOnClickListener);
            this.etL.setDefaultErrorResource(0);
            this.etL.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etL.setDrawerType(0);
            this.etP.setIsRound(true);
            this.etP.setDrawBorder(true);
            this.etP.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.etP.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.etP.setIsGod(false);
            this.etP.setIsBigV(false);
            this.etP.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etO.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.etO.setLayoutParams(layoutParams);
        }
    }
}
