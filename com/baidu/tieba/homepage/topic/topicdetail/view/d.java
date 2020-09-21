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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
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
    private boolean ajR;
    private TextView dWe;
    private TbPageContext ehG;
    private ConstrainImageGroup hqS;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jcT;
    private ClickableHeaderImageView jcU;
    private ImageView jcV;
    private TextView jcW;
    private AgreeView jcX;
    private TextView jcY;
    private ImageView jcZ;
    private TbRichTextView jda;
    private RelativeLayout jdb;
    private View jdc;
    private TbImageView jdd;
    private TextView jde;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ajR = true;
        this.mSkinType = 3;
        this.ehG = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jcU = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jcV = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dWe = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jcW = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jda = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jda.setClickable(true);
        this.jda.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jda.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jda.setLayoutStrategy(aVar);
        this.jdb = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hqS = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hqS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.u(1.0d);
        this.hqS.setImageProcessor(aVar2);
        this.jcX = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jcX.bkZ();
        this.jcY = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jcZ = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jdc = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jdd = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jdd.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jdd.setConrers(5);
        this.jdd.setDrawCorner(true);
        this.jde = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dWe.setOnClickListener(this);
        this.jcY.setOnClickListener(this);
        this.jcZ.setOnClickListener(this);
        this.jda.setOnClickListener(this);
        this.jdc.setOnClickListener(this);
        this.jde.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jcT != null) {
            this.mSkinType = i;
            this.jcU.setIsNight(this.mSkinType == 1);
            if (this.jcT.jce) {
                if (this.jcT.jcd == 1) {
                    ap.setImageResource(this.jcV, R.drawable.label_topic_agree_red);
                    this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.jcT.jcd == 2) {
                    ap.setImageResource(this.jcV, R.drawable.label_topic_disagree_blue);
                    this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ap.setImageResource(this.jcV, R.drawable.label_topic_eat_black);
                    this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ap.setViewTextColor(this.dWe, R.color.cp_cont_b);
            ap.setViewTextColor(this.jcW, R.color.cp_cont_d);
            ap.setViewTextColor(this.jcY, R.color.cp_cont_j);
            if (this.jcZ != null) {
                SvgManager.bkl().a(this.jcZ, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.jcX.onChangeSkinType(i);
            this.jda.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.c(this.jdc, l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jde, R.color.cp_cont_d);
            this.hqS.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
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
        int bfp;
        AgreeData bhp;
        if (cVar != null && cVar.dXg != null) {
            this.jcT = cVar;
            onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
            bw bwVar = this.jcT.dXg;
            PostData bhb = bwVar.bhb();
            if (bhb != null) {
                this.jcU.setPlaceHolder(1);
                if (this.jcT.source == 1) {
                    this.jcU.setData(bwVar, false, true);
                } else {
                    this.jcU.setData(bwVar, false, false);
                }
                this.jcU.setIsRound(true);
                this.jcU.setBorderWidth(2);
                this.jcU.setDrawBorder(true);
                this.jcU.setPageId(this.ehG.getUniqueId());
                if (this.jcT.jce) {
                    this.jcV.setVisibility(0);
                    if (this.jcT.jcd == 1) {
                        this.jcV.setImageResource(R.drawable.label_topic_agree_red);
                        this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.jcT.jcd == 2) {
                        this.jcV.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.jcV.setImageResource(R.drawable.label_topic_eat_black);
                        this.jcU.setBorderColor(this.ehG.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.jcV.setVisibility(8);
                }
                if (this.jcT.source == 1) {
                    name_show = bhb.bfy().getName_show();
                    formatTime = at.getFormatTime(bhb.getTime());
                    bfp = bhb.dAH();
                } else {
                    name_show = bwVar.bfy().getName_show();
                    formatTime = at.getFormatTime(bwVar.getCreateTime());
                    bfp = bwVar.bfp();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dWe.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bwVar.bfC())) {
                    this.jcW.setText(formatTime);
                } else {
                    this.jcW.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bwVar.bfC(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bkl().a(this.jcZ, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bfp);
                if (bfp > 0) {
                    this.jcY.setVisibility(0);
                    this.jcY.setText(numFormatOverWan);
                } else {
                    this.jcY.setText(this.ehG.getString(R.string.action_comment_default));
                    this.jcY.setVisibility(0);
                }
                if (this.jcT.source == 1) {
                    bhp = bhb.bhp();
                    bhp.objType = 1;
                } else {
                    bhp = bwVar.bhp();
                    bhp.objType = 3;
                }
                bhp.threadId = bwVar.getTid();
                this.jcX.setData(bhp);
                this.jcX.setTopicId(String.valueOf(this.jcT.topicId));
                a(bhb, bwVar);
                a(cVar, bwVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bw bwVar) {
        if (this.jcT.source == 1) {
            this.jda.setVisibility(0);
            this.jda.setText(postData.dAF());
            return;
        }
        List<PbContent> bfo = bwVar.bfo();
        if (y.getCount(bfo) > 0) {
            this.jda.setVisibility(0);
            this.jda.setText(TbRichTextView.a(getContext(), bfo, false));
            return;
        }
        SpannableString bgt = bwVar.bgt();
        if (bgt != null && !StringUtils.isNull(bgt.toString())) {
            this.jda.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bgt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jda.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jda.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bw bwVar) {
        if (this.jcT.source == 1) {
            this.jdc.setVisibility(0);
            this.jdb.setVisibility(8);
            String title = bwVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jdc.setVisibility(8);
                return;
            }
            this.jdc.setVisibility(0);
            this.jde.setText(title);
            String str = null;
            if (y.getCount(bwVar.bfH()) != 0 && !y.isEmpty(cVar.dXg.bfH())) {
                Iterator<MediaData> it = cVar.dXg.bfH().iterator();
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
                ap.setImageResource(this.jdd, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jdd.setPlaceHolder(1);
            this.jdd.startLoad(str, 10, false);
            return;
        }
        this.jdc.setVisibility(8);
        this.jdb.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bw bwVar = cVar.dXg;
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && y.getCount(bfH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jdb.setVisibility(0);
                this.hqS.setFromCDN(this.ajR);
                this.hqS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bwVar);
                        } else {
                            d.this.bqz();
                        }
                    }
                });
                this.hqS.setImageMediaList(linkedList);
                return;
            }
            this.jdb.setVisibility(8);
            return;
        }
        this.jdb.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hqS != null) {
            this.hqS.setPageUniqueId(bdUniqueId);
        }
    }

    public void bqz() {
        if (this.jcT != null && this.jcT.dXg != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ehG.getPageActivity()).createFromThreadCfg(this.jcT.dXg, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jcT.dXg.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jcT.dXg.bfC());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Hw(this.jcT.dXg.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cCO() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.ehG.getPageActivity()).createNormalCfg(String.valueOf(this.jcT.dXg.getTid()), String.format("%1$s", this.jcT.dXg.bhb().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                    imageUrlData.urlType = this.ajR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        aVar.x(arrayList).mX(i).zl(bwVar.bfC()).zm(String.valueOf(bwVar.getFid())).zn(bwVar.getTid()).hF(this.ajR).zo(arrayList.size() > 0 ? arrayList.get(0) : "").hG(true).a(concurrentHashMap).hH(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dO = aVar.dO(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dO.getIntent().putExtra("from", "index");
        } else {
            dO.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bfC();
        historyMessage.postID = bwVar.bfP();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jcT != null && this.jcT.dXg != null) {
            if (view == this.jda) {
                if (this.jcT.source == 1) {
                    cCO();
                } else {
                    bqz();
                }
                Kp("1");
            }
            if (view == this.jcY || view == this.jcZ) {
                if (this.jcT.source == 1) {
                    cCO();
                } else {
                    bqz();
                }
                Kp("3");
            } else if (view == this.dWe) {
                cCP();
            } else {
                bqz();
                Kp("2");
            }
        }
    }

    private void cCP() {
        MetaData bfy;
        if (this.jcT != null && this.jcT.dXg != null) {
            bw bwVar = this.jcT.dXg;
            if (this.jcT.source == 1 && bwVar.bhb() != null) {
                bfy = bwVar.bhb().bfy();
            } else {
                bfy = bwVar.bfy();
            }
            if (bfy != null && !StringUtils.isNull(bfy.getName_show()) && !StringUtils.isNull(bfy.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bfy.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bfy.isBigV());
                createNormalConfig.setSourceTid(bwVar.getTid());
                createNormalConfig.setSourceNid(bwVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Kp(String str) {
        TiebaStatic.log(new aq("c13356").dF("obj_locate", str).dF("tid", this.jcT.dXg.getTid()).u("topic_id", this.jcT.topicId).dF("obj_type", String.valueOf(this.jcT.source)));
    }
}
