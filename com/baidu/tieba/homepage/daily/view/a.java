package com.baidu.tieba.homepage.daily.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bh> {
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private final View.OnClickListener cpN;
    private bh cry;
    private final View.OnClickListener csI;
    private ThreadCommentAndPraiseInfoLayout dTr;
    private View deR;
    private ConstrainImageGroup eNi;
    private View.OnClickListener eNn;
    private final View.OnClickListener eNo;
    private View gfm;
    private ThreadForumUserInfoLayout ggn;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.HY = true;
        this.mStType = null;
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.cry);
                }
                a.this.asj();
            }
        };
        this.eNo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZX = a.this.aZX();
                if (aZX != null) {
                    view.setTag("2");
                    aZX.a(view, a.this.cry);
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.cry);
                }
            }
        };
        this.csI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.cry);
                }
            }
        };
        View view = getView();
        this.ggn = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.ggn.setForumAfterClickListener(this.cpN);
        this.ggn.setLikeButtonAfterClickListener(this.csI);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Ii = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.Ii.setAfterClickListener(this.eNo);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eNi.setChildClickListener(this.eNn);
        this.eNi.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.g(1.0d);
        fVar.fJ(false);
        this.eNi.setImageProcessor(fVar);
        this.gfm = view.findViewById(R.id.no_image_divider_line);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dTr.setOnClickListener(this.eNn);
        this.dTr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view2, a.this.cry);
                }
                if (a.this.cry != null) {
                    n.uz(a.this.cry.getId());
                    a.this.btf();
                }
            }
        });
        this.dTr.setShowCommonView();
        this.deR = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eNi != null) {
            this.eNi.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ggn != null) {
            this.ggn.setPageUniqueId(bdUniqueId);
        }
        if (this.eNi != null) {
            this.eNi.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.ggn.onChangeSkinType(i);
            this.eNi.onChangeSkinType();
            this.dTr.onChangeSkinType();
            am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cry = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eNn);
        }
        this.ggn.setData(this.cry);
        ag(this.cry);
        ArrayList<VoiceData.VoiceModel> aiU = this.cry.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
            iI(false);
        } else {
            this.Ii.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = aiU.get(0);
            this.Ii.setVoiceModel(voiceModel);
            this.Ii.setTag(voiceModel);
            this.Ii.bnq();
            if (voiceModel != null) {
                this.Ii.uK(voiceModel.voice_status.intValue());
            }
            this.Ii.cpC();
        }
        ArrayList<MediaData> aiQ = this.cry.aiQ();
        if (i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.eNi.setVisibility(0);
                this.gfm.setVisibility(8);
                this.eNi.setFromCDN(this.HY);
                this.eNi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bh> aZX = a.this.aZX();
                        if (aZX != null) {
                            view.setTag("1");
                            aZX.a(view, a.this.cry);
                        }
                        a.this.asj();
                    }
                });
                this.eNi.setImageMediaList(linkedList);
            } else {
                this.eNi.setVisibility(8);
                this.gfm.setVisibility(0);
            }
        } else {
            this.eNi.setVisibility(8);
            this.gfm.setVisibility(0);
        }
        this.dTr.cqT = this.currentPageType;
        this.dTr.setData(this.cry);
        bns();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bh bhVar) {
        SpannableStringBuilder s = bhVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        if (n.uA(this.cry.getId())) {
            n.a(this.mTitle, this.cry.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bns() {
        if (this.mTitle != null && this.Ii != null && this.eNi != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ii.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ii.setLayoutParams(layoutParams);
            if (this.Ii.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eNi.setLayoutParams(layoutParams2);
            }
        }
    }

    private void iI(boolean z) {
        if (this.eNi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eNi.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asj() {
        if (this.cry != null) {
            n.uz(this.cry.getId());
            n.a(this.mTitle, this.cry.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cry, null, this.mStType, RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.cry.aks() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cry.getFid()));
                createFromThreadCfg.setForumName(this.cry.aiL());
            } else {
                createFromThreadCfg.setForumId(this.cry.aks().getForumId());
                createFromThreadCfg.setForumName(this.cry.aks().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public int bts() {
        if (this.ggn == null || this.ggn.getHeaderImg() == null) {
            return -1;
        }
        return this.ggn.getHeaderImg().getId();
    }

    public int btt() {
        if (this.ggn == null || this.ggn.getForumName() == null) {
            return -1;
        }
        return this.ggn.getForumName().getId();
    }

    public int btu() {
        if (this.ggn == null || this.ggn.getForumName() == null) {
            return -1;
        }
        return this.ggn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dTr != null) {
            this.dTr.setShareReportFrom(i);
        }
    }

    public void sG(int i) {
        if (this.dTr != null) {
            this.dTr.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dTr != null) {
            this.dTr.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
