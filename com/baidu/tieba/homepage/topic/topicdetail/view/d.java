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
    private ConstrainImageGroup ijF;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jYG;
    private ClickableHeaderImageView jYH;
    private ImageView jYI;
    private TextView jYJ;
    private AgreeView jYK;
    private TextView jYL;
    private ImageView jYM;
    private TbRichTextView jYN;
    private RelativeLayout jYO;
    private View jYP;
    private TbImageView jYQ;
    private TextView jYR;
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
        this.jYH = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jYI = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eBQ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jYJ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jYN = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jYN.setClickable(true);
        this.jYN.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jYN.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jYN.setLayoutStrategy(aVar);
        this.jYO = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.ijF = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.ijF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.x(1.0d);
        this.ijF.setImageProcessor(aVar2);
        this.jYK = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jYK.buN();
        this.jYL = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jYM = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jYP = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jYQ = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jYQ.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jYQ.setConrers(5);
        this.jYQ.setDrawCorner(true);
        this.jYR = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eBQ.setOnClickListener(this);
        this.jYL.setOnClickListener(this);
        this.jYM.setOnClickListener(this);
        this.jYN.setOnClickListener(this);
        this.jYP.setOnClickListener(this);
        this.jYR.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijF != null) {
            this.ijF.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijF != null) {
            this.ijF.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jYG != null) {
            this.mSkinType = i;
            this.jYH.setIsNight(this.mSkinType == 1);
            if (this.jYG.jXQ) {
                if (this.jYG.jXP == 1) {
                    ap.setImageResource(this.jYI, R.drawable.label_topic_agree_red);
                    this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.jYG.jXP == 2) {
                    ap.setImageResource(this.jYI, R.drawable.label_topic_disagree_blue);
                    this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ap.setImageResource(this.jYI, R.drawable.label_topic_eat_black);
                    this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.jYJ, R.color.CAM_X0109);
            ap.setViewTextColor(this.jYL, R.color.CAM_X0107);
            if (this.jYM != null) {
                SvgManager.btW().a(this.jYM, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.jYK.onChangeSkinType(i);
            this.jYN.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.d(this.jYP, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jYR, R.color.CAM_X0109);
            this.ijF.onChangeSkinType();
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
            this.jYG = cVar;
            onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
            by byVar = this.jYG.eCR;
            PostData bqu = byVar.bqu();
            if (bqu != null) {
                this.jYH.setPlaceHolder(1);
                if (this.jYG.source == 1) {
                    this.jYH.setData(byVar, false, true);
                } else {
                    this.jYH.setData(byVar, false, false);
                }
                this.jYH.setIsRound(true);
                this.jYH.setBorderWidth(2);
                this.jYH.setDrawBorder(true);
                this.jYH.setPageId(this.eNx.getUniqueId());
                if (this.jYG.jXQ) {
                    this.jYI.setVisibility(0);
                    if (this.jYG.jXP == 1) {
                        this.jYI.setImageResource(R.drawable.label_topic_agree_red);
                        this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.jYG.jXP == 2) {
                        this.jYI.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.jYI.setImageResource(R.drawable.label_topic_eat_black);
                        this.jYH.setBorderColor(this.eNx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.jYI.setVisibility(8);
                }
                if (this.jYG.source == 1) {
                    name_show = bqu.boP().getName_show();
                    formatTime = au.getFormatTime(bqu.getTime());
                    boG = bqu.dPl();
                } else {
                    name_show = byVar.boP().getName_show();
                    formatTime = au.getFormatTime(byVar.getCreateTime());
                    boG = byVar.boG();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eBQ.setText(au.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(byVar.boT())) {
                    this.jYJ.setText(formatTime);
                } else {
                    this.jYJ.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), au.cutChineseAndEnglishWithSuffix(byVar.boT(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.btW().a(this.jYM, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = au.numFormatOverWan(boG);
                if (boG > 0) {
                    this.jYL.setVisibility(0);
                    this.jYL.setText(numFormatOverWan);
                } else {
                    this.jYL.setText(this.eNx.getString(R.string.action_comment_default));
                    this.jYL.setVisibility(0);
                }
                if (this.jYG.source == 1) {
                    bqI = bqu.bqI();
                    bqI.objType = 1;
                } else {
                    bqI = byVar.bqI();
                    bqI.objType = 3;
                }
                bqI.threadId = byVar.getTid();
                this.jYK.setData(bqI);
                this.jYK.setTopicId(String.valueOf(this.jYG.topicId));
                a(bqu, byVar);
                a(cVar, byVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, by byVar) {
        if (this.jYG.source == 1) {
            this.jYN.setVisibility(0);
            this.jYN.setText(postData.dPj());
            return;
        }
        List<PbContent> boF = byVar.boF();
        if (y.getCount(boF) > 0) {
            this.jYN.setVisibility(0);
            this.jYN.setText(TbRichTextView.a(getContext(), boF, false));
            return;
        }
        SpannableString bpM = byVar.bpM();
        if (bpM != null && !StringUtils.isNull(bpM.toString())) {
            this.jYN.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bpM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jYN.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jYN.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, by byVar) {
        if (this.jYG.source == 1) {
            this.jYP.setVisibility(0);
            this.jYO.setVisibility(8);
            String title = byVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jYP.setVisibility(8);
                return;
            }
            this.jYP.setVisibility(0);
            this.jYR.setText(title);
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
                ap.setImageResource(this.jYQ, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jYQ.setPlaceHolder(1);
            this.jYQ.startLoad(str, 10, false);
            return;
        }
        this.jYP.setVisibility(8);
        this.jYO.setVisibility(0);
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
                this.jYO.setVisibility(0);
                this.ijF.setFromCDN(this.alo);
                this.ijF.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, byVar);
                        } else {
                            d.this.bAr();
                        }
                    }
                });
                this.ijF.setImageMediaList(linkedList);
                return;
            }
            this.jYO.setVisibility(8);
            return;
        }
        this.jYO.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ijF != null) {
            this.ijF.setPageUniqueId(bdUniqueId);
        }
    }

    public void bAr() {
        if (this.jYG != null && this.jYG.eCR != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eNx.getPageActivity()).createFromThreadCfg(this.jYG.eCR, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jYG.eCR.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jYG.eCR.boT());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            n.Jq(this.jYG.eCR.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cRb() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eNx.getPageActivity()).createNormalCfg(String.valueOf(this.jYG.eCR.getTid()), String.format("%1$s", this.jYG.eCR.bqu().getId()) + "", 1, "mention");
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
        if (this.jYG != null && this.jYG.eCR != null) {
            if (view == this.jYN) {
                if (this.jYG.source == 1) {
                    cRb();
                } else {
                    bAr();
                }
                MB("1");
            }
            if (view == this.jYL || view == this.jYM) {
                if (this.jYG.source == 1) {
                    cRb();
                } else {
                    bAr();
                }
                MB("3");
            } else if (view == this.eBQ) {
                cRc();
            } else {
                bAr();
                MB("2");
            }
        }
    }

    private void cRc() {
        MetaData boP;
        if (this.jYG != null && this.jYG.eCR != null) {
            by byVar = this.jYG.eCR;
            if (this.jYG.source == 1 && byVar.bqu() != null) {
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
        TiebaStatic.log(new ar("c13356").dY("obj_locate", str).dY("tid", this.jYG.eCR.getTid()).w("topic_id", this.jYG.topicId).dY("obj_type", String.valueOf(this.jYG.source)));
    }
}
