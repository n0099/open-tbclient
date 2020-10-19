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
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean akj;
    private TextView eig;
    private TbPageContext etO;
    private ConstrainImageGroup hFM;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jrS;
    private ClickableHeaderImageView jrT;
    private ImageView jrU;
    private TextView jrV;
    private AgreeView jrW;
    private TextView jrX;
    private ImageView jrY;
    private TbRichTextView jrZ;
    private RelativeLayout jsa;
    private View jsb;
    private TbImageView jsc;
    private TextView jsd;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akj = true;
        this.mSkinType = 3;
        this.etO = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jrT = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jrU = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eig = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jrV = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jrZ = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jrZ.setClickable(true);
        this.jrZ.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jrZ.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jrZ.setLayoutStrategy(aVar);
        this.jsa = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hFM = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hFM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.x(1.0d);
        this.hFM.setImageProcessor(aVar2);
        this.jrW = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jrW.bnJ();
        this.jrX = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jrY = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jsb = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jsc = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jsc.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jsc.setConrers(5);
        this.jsc.setDrawCorner(true);
        this.jsd = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eig.setOnClickListener(this);
        this.jrX.setOnClickListener(this);
        this.jrY.setOnClickListener(this);
        this.jrZ.setOnClickListener(this);
        this.jsb.setOnClickListener(this);
        this.jsd.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jrS != null) {
            this.mSkinType = i;
            this.jrT.setIsNight(this.mSkinType == 1);
            if (this.jrS.jrd) {
                if (this.jrS.jrc == 1) {
                    ap.setImageResource(this.jrU, R.drawable.label_topic_agree_red);
                    this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.jrS.jrc == 2) {
                    ap.setImageResource(this.jrU, R.drawable.label_topic_disagree_blue);
                    this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ap.setImageResource(this.jrU, R.drawable.label_topic_eat_black);
                    this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ap.setViewTextColor(this.eig, R.color.cp_cont_b);
            ap.setViewTextColor(this.jrV, R.color.cp_cont_d);
            ap.setViewTextColor(this.jrX, R.color.cp_cont_j);
            if (this.jrY != null) {
                SvgManager.bmU().a(this.jrY, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.jrW.onChangeSkinType(i);
            this.jrZ.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.c(this.jsb, l.getDimens(this.etO.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jsd, R.color.cp_cont_d);
            this.hFM.onChangeSkinType();
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
        int bhY;
        AgreeData bjY;
        if (cVar != null && cVar.eji != null) {
            this.jrS = cVar;
            onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
            bw bwVar = this.jrS.eji;
            PostData bjK = bwVar.bjK();
            if (bjK != null) {
                this.jrT.setPlaceHolder(1);
                if (this.jrS.source == 1) {
                    this.jrT.setData(bwVar, false, true);
                } else {
                    this.jrT.setData(bwVar, false, false);
                }
                this.jrT.setIsRound(true);
                this.jrT.setBorderWidth(2);
                this.jrT.setDrawBorder(true);
                this.jrT.setPageId(this.etO.getUniqueId());
                if (this.jrS.jrd) {
                    this.jrU.setVisibility(0);
                    if (this.jrS.jrc == 1) {
                        this.jrU.setImageResource(R.drawable.label_topic_agree_red);
                        this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.jrS.jrc == 2) {
                        this.jrU.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.jrU.setImageResource(R.drawable.label_topic_eat_black);
                        this.jrT.setBorderColor(this.etO.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.jrU.setVisibility(8);
                }
                if (this.jrS.source == 1) {
                    name_show = bjK.bih().getName_show();
                    formatTime = at.getFormatTime(bjK.getTime());
                    bhY = bjK.dEt();
                } else {
                    name_show = bwVar.bih().getName_show();
                    formatTime = at.getFormatTime(bwVar.getCreateTime());
                    bhY = bwVar.bhY();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eig.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bwVar.bil())) {
                    this.jrV.setText(formatTime);
                } else {
                    this.jrV.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bwVar.bil(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bmU().a(this.jrY, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bhY);
                if (bhY > 0) {
                    this.jrX.setVisibility(0);
                    this.jrX.setText(numFormatOverWan);
                } else {
                    this.jrX.setText(this.etO.getString(R.string.action_comment_default));
                    this.jrX.setVisibility(0);
                }
                if (this.jrS.source == 1) {
                    bjY = bjK.bjY();
                    bjY.objType = 1;
                } else {
                    bjY = bwVar.bjY();
                    bjY.objType = 3;
                }
                bjY.threadId = bwVar.getTid();
                this.jrW.setData(bjY);
                this.jrW.setTopicId(String.valueOf(this.jrS.topicId));
                a(bjK, bwVar);
                a(cVar, bwVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bw bwVar) {
        if (this.jrS.source == 1) {
            this.jrZ.setVisibility(0);
            this.jrZ.setText(postData.dEr());
            return;
        }
        List<PbContent> bhX = bwVar.bhX();
        if (y.getCount(bhX) > 0) {
            this.jrZ.setVisibility(0);
            this.jrZ.setText(TbRichTextView.a(getContext(), bhX, false));
            return;
        }
        SpannableString bjc = bwVar.bjc();
        if (bjc != null && !StringUtils.isNull(bjc.toString())) {
            this.jrZ.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bjc);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jrZ.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jrZ.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bw bwVar) {
        if (this.jrS.source == 1) {
            this.jsb.setVisibility(0);
            this.jsa.setVisibility(8);
            String title = bwVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jsb.setVisibility(8);
                return;
            }
            this.jsb.setVisibility(0);
            this.jsd.setText(title);
            String str = null;
            if (y.getCount(bwVar.biq()) != 0 && !y.isEmpty(cVar.eji.biq())) {
                Iterator<MediaData> it = cVar.eji.biq().iterator();
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
                ap.setImageResource(this.jsc, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jsc.setPlaceHolder(1);
            this.jsc.startLoad(str, 10, false);
            return;
        }
        this.jsb.setVisibility(8);
        this.jsa.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bw bwVar = cVar.eji;
        ArrayList<MediaData> biq = bwVar.biq();
        if (k.bfo().isShowImages() && y.getCount(biq) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < biq.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(biq, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jsa.setVisibility(0);
                this.hFM.setFromCDN(this.akj);
                this.hFM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bwVar);
                        } else {
                            d.this.btj();
                        }
                    }
                });
                this.hFM.setImageMediaList(linkedList);
                return;
            }
            this.jsa.setVisibility(8);
            return;
        }
        this.jsa.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hFM != null) {
            this.hFM.setPageUniqueId(bdUniqueId);
        }
    }

    public void btj() {
        if (this.jrS != null && this.jrS.eji != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.etO.getPageActivity()).createFromThreadCfg(this.jrS.eji, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jrS.eji.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jrS.eji.bil());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Ij(this.jrS.eji.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cGx() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.etO.getPageActivity()).createNormalCfg(String.valueOf(this.jrS.eji.getTid()), String.format("%1$s", this.jrS.eji.bjK().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.akj ? 13 : 14;
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
        aVar.x(arrayList).nu(i).zX(bwVar.bil()).zY(String.valueOf(bwVar.getFid())).zZ(bwVar.getTid()).ib(this.akj).Aa(arrayList.size() > 0 ? arrayList.get(0) : "").ic(true).a(concurrentHashMap).id(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bil();
        historyMessage.postID = bwVar.biy();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jrS != null && this.jrS.eji != null) {
            if (view == this.jrZ) {
                if (this.jrS.source == 1) {
                    cGx();
                } else {
                    btj();
                }
                Le("1");
            }
            if (view == this.jrX || view == this.jrY) {
                if (this.jrS.source == 1) {
                    cGx();
                } else {
                    btj();
                }
                Le("3");
            } else if (view == this.eig) {
                cGy();
            } else {
                btj();
                Le("2");
            }
        }
    }

    private void cGy() {
        MetaData bih;
        if (this.jrS != null && this.jrS.eji != null) {
            bw bwVar = this.jrS.eji;
            if (this.jrS.source == 1 && bwVar.bjK() != null) {
                bih = bwVar.bjK().bih();
            } else {
                bih = bwVar.bih();
            }
            if (bih != null && !StringUtils.isNull(bih.getName_show()) && !StringUtils.isNull(bih.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bih.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bih.isBigV());
                createNormalConfig.setSourceTid(bwVar.getTid());
                createNormalConfig.setSourceNid(bwVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Le(String str) {
        TiebaStatic.log(new aq("c13356").dK("obj_locate", str).dK("tid", this.jrS.eji.getTid()).u("topic_id", this.jrS.topicId).dK("obj_type", String.valueOf(this.jrS.source)));
    }
}
