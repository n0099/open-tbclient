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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean akn;
    private TbPageContext eGu;
    private TextView euO;
    private ConstrainImageGroup hYG;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jLb;
    private ClickableHeaderImageView jLc;
    private ImageView jLd;
    private TextView jLe;
    private AgreeView jLf;
    private TextView jLg;
    private ImageView jLh;
    private TbRichTextView jLi;
    private RelativeLayout jLj;
    private View jLk;
    private TbImageView jLl;
    private TextView jLm;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akn = true;
        this.mSkinType = 3;
        this.eGu = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jLc = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jLd = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.euO = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jLe = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jLi = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jLi.setClickable(true);
        this.jLi.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jLi.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jLi.setLayoutStrategy(aVar);
        this.jLj = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hYG = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hYG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.x(1.0d);
        this.hYG.setImageProcessor(aVar2);
        this.jLf = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jLf.brq();
        this.jLg = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jLh = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jLk = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jLl = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jLl.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jLl.setConrers(5);
        this.jLl.setDrawCorner(true);
        this.jLm = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.euO.setOnClickListener(this);
        this.jLg.setOnClickListener(this);
        this.jLh.setOnClickListener(this);
        this.jLi.setOnClickListener(this);
        this.jLk.setOnClickListener(this);
        this.jLm.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYG != null) {
            this.hYG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYG != null) {
            this.hYG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jLb != null) {
            this.mSkinType = i;
            this.jLc.setIsNight(this.mSkinType == 1);
            if (this.jLb.jKl) {
                if (this.jLb.jKk == 1) {
                    ap.setImageResource(this.jLd, R.drawable.label_topic_agree_red);
                    this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.jLb.jKk == 2) {
                    ap.setImageResource(this.jLd, R.drawable.label_topic_disagree_blue);
                    this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ap.setImageResource(this.jLd, R.drawable.label_topic_eat_black);
                    this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ap.setViewTextColor(this.euO, R.color.CAM_X0105);
            ap.setViewTextColor(this.jLe, R.color.CAM_X0109);
            ap.setViewTextColor(this.jLg, R.color.CAM_X0107);
            if (this.jLh != null) {
                SvgManager.bqB().a(this.jLh, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.jLf.onChangeSkinType(i);
            this.jLi.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.c(this.jLk, l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jLm, R.color.CAM_X0109);
            this.hYG.onChangeSkinType();
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
        int blt;
        AgreeData bnv;
        if (cVar != null && cVar.evQ != null) {
            this.jLb = cVar;
            onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
            bx bxVar = this.jLb.evQ;
            PostData bnh = bxVar.bnh();
            if (bnh != null) {
                this.jLc.setPlaceHolder(1);
                if (this.jLb.source == 1) {
                    this.jLc.setData(bxVar, false, true);
                } else {
                    this.jLc.setData(bxVar, false, false);
                }
                this.jLc.setIsRound(true);
                this.jLc.setBorderWidth(2);
                this.jLc.setDrawBorder(true);
                this.jLc.setPageId(this.eGu.getUniqueId());
                if (this.jLb.jKl) {
                    this.jLd.setVisibility(0);
                    if (this.jLb.jKk == 1) {
                        this.jLd.setImageResource(R.drawable.label_topic_agree_red);
                        this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.jLb.jKk == 2) {
                        this.jLd.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.jLd.setImageResource(R.drawable.label_topic_eat_black);
                        this.jLc.setBorderColor(this.eGu.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.jLd.setVisibility(8);
                }
                if (this.jLb.source == 1) {
                    name_show = bnh.blC().getName_show();
                    formatTime = au.getFormatTime(bnh.getTime());
                    blt = bnh.dJU();
                } else {
                    name_show = bxVar.blC().getName_show();
                    formatTime = au.getFormatTime(bxVar.getCreateTime());
                    blt = bxVar.blt();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.euO.setText(au.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bxVar.blG())) {
                    this.jLe.setText(formatTime);
                } else {
                    this.jLe.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), au.cutChineseAndEnglishWithSuffix(bxVar.blG(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bqB().a(this.jLh, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = au.numFormatOverWan(blt);
                if (blt > 0) {
                    this.jLg.setVisibility(0);
                    this.jLg.setText(numFormatOverWan);
                } else {
                    this.jLg.setText(this.eGu.getString(R.string.action_comment_default));
                    this.jLg.setVisibility(0);
                }
                if (this.jLb.source == 1) {
                    bnv = bnh.bnv();
                    bnv.objType = 1;
                } else {
                    bnv = bxVar.bnv();
                    bnv.objType = 3;
                }
                bnv.threadId = bxVar.getTid();
                this.jLf.setData(bnv);
                this.jLf.setTopicId(String.valueOf(this.jLb.topicId));
                a(bnh, bxVar);
                a(cVar, bxVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bx bxVar) {
        if (this.jLb.source == 1) {
            this.jLi.setVisibility(0);
            this.jLi.setText(postData.dJS());
            return;
        }
        List<PbContent> bls = bxVar.bls();
        if (y.getCount(bls) > 0) {
            this.jLi.setVisibility(0);
            this.jLi.setText(TbRichTextView.a(getContext(), bls, false));
            return;
        }
        SpannableString bmz = bxVar.bmz();
        if (bmz != null && !StringUtils.isNull(bmz.toString())) {
            this.jLi.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bmz);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jLi.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jLi.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bx bxVar) {
        if (this.jLb.source == 1) {
            this.jLk.setVisibility(0);
            this.jLj.setVisibility(8);
            String title = bxVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jLk.setVisibility(8);
                return;
            }
            this.jLk.setVisibility(0);
            this.jLm.setText(title);
            String str = null;
            if (y.getCount(bxVar.blL()) != 0 && !y.isEmpty(cVar.evQ.blL())) {
                Iterator<MediaData> it = cVar.evQ.blL().iterator();
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
                ap.setImageResource(this.jLl, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jLl.setPlaceHolder(1);
            this.jLl.startLoad(str, 10, false);
            return;
        }
        this.jLk.setVisibility(8);
        this.jLj.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bx bxVar = cVar.evQ;
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jLj.setVisibility(0);
                this.hYG.setFromCDN(this.akn);
                this.hYG.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bxVar);
                        } else {
                            d.this.bwR();
                        }
                    }
                });
                this.hYG.setImageMediaList(linkedList);
                return;
            }
            this.jLj.setVisibility(8);
            return;
        }
        this.jLj.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hYG != null) {
            this.hYG.setPageUniqueId(bdUniqueId);
        }
    }

    public void bwR() {
        if (this.jLb != null && this.jLb.evQ != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eGu.getPageActivity()).createFromThreadCfg(this.jLb.evQ, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jLb.evQ.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jLb.evQ.blG());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            n.IA(this.jLb.evQ.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cLM() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eGu.getPageActivity()).createNormalCfg(String.valueOf(this.jLb.evQ.getTid()), String.format("%1$s", this.jLb.evQ.bnh().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bx bxVar) {
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
                    imageUrlData.urlType = this.akn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bxVar.getTid(), -1L);
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
        aVar.x(arrayList).nL(i).zZ(bxVar.blG()).Aa(String.valueOf(bxVar.getFid())).Ab(bxVar.getTid()).iy(this.akn).Ac(arrayList.size() > 0 ? arrayList.get(0) : "").iz(true).a(concurrentHashMap).iA(true).s(bxVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bxVar.getId();
        historyMessage.threadName = bxVar.getTitle();
        historyMessage.forumName = bxVar.blG();
        historyMessage.postID = bxVar.blT();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLb != null && this.jLb.evQ != null) {
            if (view == this.jLi) {
                if (this.jLb.source == 1) {
                    cLM();
                } else {
                    bwR();
                }
                Lu("1");
            }
            if (view == this.jLg || view == this.jLh) {
                if (this.jLb.source == 1) {
                    cLM();
                } else {
                    bwR();
                }
                Lu("3");
            } else if (view == this.euO) {
                cLN();
            } else {
                bwR();
                Lu("2");
            }
        }
    }

    private void cLN() {
        MetaData blC;
        if (this.jLb != null && this.jLb.evQ != null) {
            bx bxVar = this.jLb.evQ;
            if (this.jLb.source == 1 && bxVar.bnh() != null) {
                blC = bxVar.bnh().blC();
            } else {
                blC = bxVar.blC();
            }
            if (blC != null && !StringUtils.isNull(blC.getName_show()) && !StringUtils.isNull(blC.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(blC.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), blC.isBigV());
                createNormalConfig.setSourceTid(bxVar.getTid());
                createNormalConfig.setSourceNid(bxVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Lu(String str) {
        TiebaStatic.log(new ar("c13356").dR("obj_locate", str).dR("tid", this.jLb.evQ.getTid()).w("topic_id", this.jLb.topicId).dR("obj_type", String.valueOf(this.jLb.source)));
    }
}
