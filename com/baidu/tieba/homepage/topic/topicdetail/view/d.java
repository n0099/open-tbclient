package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean alo;
    private TextView eBQ;
    private TbPageContext eNx;
    private ConstrainImageGroup ijD;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jYE;
    private ClickableHeaderImageView jYF;
    private ImageView jYG;
    private TextView jYH;
    private AgreeView jYI;
    private TextView jYJ;
    private ImageView jYK;
    private TbRichTextView jYL;
    private RelativeLayout jYM;
    private View jYN;
    private TbImageView jYO;
    private TextView jYP;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.alo = true;
        this.mSkinType = 3;
        this.eNx = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jYF = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jYG = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eBQ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jYH = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jYL = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jYL.setClickable(true);
        this.jYL.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jYL.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jYL.setLayoutStrategy(aVar);
        this.jYM = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.ijD = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.ijD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.x(1.0d);
        this.ijD.setImageProcessor(aVar2);
        this.jYI = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jYI.buN();
        this.jYJ = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jYK = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jYN = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jYO = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jYO.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jYO.setConrers(5);
        this.jYO.setDrawCorner(true);
        this.jYP = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eBQ.setOnClickListener(this);
        this.jYJ.setOnClickListener(this);
        this.jYK.setOnClickListener(this);
        this.jYL.setOnClickListener(this);
        this.jYN.setOnClickListener(this);
        this.jYP.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijD != null) {
            this.ijD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijD != null) {
            this.ijD.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jYE != null) {
            this.mSkinType = i;
            this.jYF.setIsNight(this.mSkinType == 1);
            if (this.jYE.jXO) {
                if (this.jYE.jXN == 1) {
                    ap.setImageResource(this.jYG, R.drawable.label_topic_agree_red);
                    this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.jYE.jXN == 2) {
                    ap.setImageResource(this.jYG, R.drawable.label_topic_disagree_blue);
                    this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ap.setImageResource(this.jYG, R.drawable.label_topic_eat_black);
                    this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.jYH, R.color.CAM_X0109);
            ap.setViewTextColor(this.jYJ, R.color.CAM_X0107);
            if (this.jYK != null) {
                SvgManager.btW().a(this.jYK, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.jYI.onChangeSkinType(i);
            this.jYL.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.d(this.jYN, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jYP, R.color.CAM_X0109);
            this.ijD.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0205);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int boG;
        AgreeData bqI;
        if (cVar != null && cVar.eCR != null) {
            this.jYE = cVar;
            onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
            by byVar = this.jYE.eCR;
            PostData bqu = byVar.bqu();
            if (bqu != null) {
                this.jYF.setPlaceHolder(1);
                if (this.jYE.source == 1) {
                    this.jYF.setData(byVar, false, true);
                } else {
                    this.jYF.setData(byVar, false, false);
                }
                this.jYF.setIsRound(true);
                this.jYF.setBorderWidth(2);
                this.jYF.setDrawBorder(true);
                this.jYF.setPageId(this.eNx.getUniqueId());
                if (this.jYE.jXO) {
                    this.jYG.setVisibility(0);
                    if (this.jYE.jXN == 1) {
                        this.jYG.setImageResource(R.drawable.label_topic_agree_red);
                        this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.jYE.jXN == 2) {
                        this.jYG.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.jYG.setImageResource(R.drawable.label_topic_eat_black);
                        this.jYF.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.jYG.setVisibility(8);
                }
                if (this.jYE.source == 1) {
                    name_show = bqu.boP().getName_show();
                    formatTime = au.getFormatTime(bqu.getTime());
                    boG = bqu.dPk();
                } else {
                    name_show = byVar.boP().getName_show();
                    formatTime = au.getFormatTime(byVar.getCreateTime());
                    boG = byVar.boG();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(byVar.boT())) {
                    this.jYH.setText(formatTime);
                } else {
                    this.jYH.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), au.cutChineseAndEnglishWithSuffix(byVar.boT(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.btW().a(this.jYK, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = au.numFormatOverWan(boG);
                if (boG > 0) {
                    this.jYJ.setVisibility(0);
                    this.jYJ.setText(numFormatOverWan);
                } else {
                    this.jYJ.setText(this.eNx.getString(R.string.action_comment_default));
                    this.jYJ.setVisibility(0);
                }
                if (this.jYE.source == 1) {
                    bqI = bqu.bqI();
                    bqI.objType = 1;
                } else {
                    bqI = byVar.bqI();
                    bqI.objType = 3;
                }
                bqI.threadId = byVar.getTid();
                this.jYI.setData(bqI);
                this.jYI.setTopicId(String.valueOf(this.jYE.topicId));
                a(bqu, byVar);
                a(cVar, byVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, by byVar) {
        if (this.jYE.source == 1) {
            this.jYL.setVisibility(0);
            this.jYL.setText(postData.dPi());
            return;
        }
        List<PbContent> boF = byVar.boF();
        if (y.getCount(boF) > 0) {
            this.jYL.setVisibility(0);
            this.jYL.setText(TbRichTextView.a(getContext(), boF, false));
            return;
        }
        SpannableString bpM = byVar.bpM();
        if (bpM != null && !StringUtils.isNull(bpM.toString())) {
            this.jYL.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bpM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jYL.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jYL.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, by byVar) {
        if (this.jYE.source == 1) {
            this.jYN.setVisibility(0);
            this.jYM.setVisibility(8);
            String title = byVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jYN.setVisibility(8);
                return;
            }
            this.jYN.setVisibility(0);
            this.jYP.setText(title);
            String str = null;
            if (y.getCount(byVar.boY()) != 0 && !y.isEmpty(cVar.eCR.boY())) {
                Iterator<MediaData> it = cVar.eCR.boY().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                ap.setImageResource(this.jYO, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jYO.setPlaceHolder(1);
            this.jYO.startLoad(str, 10, false);
            return;
        }
        this.jYN.setVisibility(8);
        this.jYM.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final by byVar = cVar.eCR;
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jYM.setVisibility(0);
                this.ijD.setFromCDN(this.alo);
                this.ijD.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, byVar);
                        } else {
                            d.this.bAr();
                        }
                    }
                });
                this.ijD.setImageMediaList(linkedList);
                return;
            }
            this.jYM.setVisibility(8);
            return;
        }
        this.jYM.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ijD != null) {
            this.ijD.setPageUniqueId(bdUniqueId);
        }
    }

    public void bAr() {
        if (this.jYE != null && this.jYE.eCR != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eNx.getPageActivity()).createFromThreadCfg(this.jYE.eCR, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jYE.eCR.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jYE.eCR.boT());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            n.Jq(this.jYE.eCR.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cRa() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eNx.getPageActivity()).createNormalCfg(String.valueOf(this.jYE.eCR.getTid()), String.format("%1$s", this.jYE.eCR.bqu().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, by byVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.alo ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(byVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).oj(i).AG(byVar.boT()).AH(String.valueOf(byVar.getFid())).AI(byVar.getTid()).iN(this.alo).AJ(arrayList.size() > 0 ? arrayList.get(0) : "").iO(true).a(concurrentHashMap).iP(true).s(byVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig ez = aVar.ez(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            ez.getIntent().putExtra("from", "index");
        } else {
            ez.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = byVar.getId();
        historyMessage.threadName = byVar.getTitle();
        historyMessage.forumName = byVar.boT();
        historyMessage.postID = byVar.bpg();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jYE != null && this.jYE.eCR != null) {
            if (view == this.jYL) {
                if (this.jYE.source == 1) {
                    cRa();
                } else {
                    bAr();
                }
                MB("1");
            }
            if (view == this.jYJ || view == this.jYK) {
                if (this.jYE.source == 1) {
                    cRa();
                } else {
                    bAr();
                }
                MB("3");
            } else if (view == this.eBQ) {
                cRb();
            } else {
                bAr();
                MB("2");
            }
        }
    }

    private void cRb() {
        MetaData boP;
        if (this.jYE != null && this.jYE.eCR != null) {
            by byVar = this.jYE.eCR;
            if (this.jYE.source == 1 && byVar.bqu() != null) {
                boP = byVar.bqu().boP();
            } else {
                boP = byVar.boP();
            }
            if (boP != null && !StringUtils.isNull(boP.getName_show()) && !StringUtils.isNull(boP.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(boP.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), boP.isBigV());
                createNormalConfig.setSourceTid(byVar.getTid());
                createNormalConfig.setSourceNid(byVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void MB(String str) {
        TiebaStatic.log(new ar("c13356").dY("obj_locate", str).dY("tid", this.jYE.eCR.getTid()).w("topic_id", this.jYE.topicId).dY("obj_type", String.valueOf(this.jYE.source)));
    }
}
