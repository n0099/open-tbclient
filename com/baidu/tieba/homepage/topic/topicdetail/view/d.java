package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeAloneView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean XJ;
    private int caF;
    private TextView cbV;
    private ConstrainImageGroup exN;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c ggm;
    private ClickableHeaderImageView ggn;
    private ImageView ggo;
    private TextView ggp;
    private AgreeAloneView ggq;
    private TextView ggr;
    private ImageView ggs;
    private TbRichTextView ggt;
    private RelativeLayout ggu;
    private View ggv;
    private TbImageView ggw;
    private TextView ggx;
    private View mBottomLine;
    private TbPageContext mContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.XJ = true;
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.caF = R.drawable.selector_topic_detail_comment_icon;
        this.ggn = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.ggo = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cbV = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.ggp = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.ggt = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.ggt.setClickable(true);
        this.ggt.getLayoutStrategy().setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.ggt.setTextEllipsize(TextUtils.TruncateAt.END);
        this.ggt.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.g(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.ggt.setLayoutStrategy(aVar);
        this.ggu = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.exN = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.exN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.exN.setImageProcessor(aVar2);
        this.ggq = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.ggr = (TextView) view.findViewById(R.id.topic_comment_number);
        this.ggs = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.ggv = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.ggw = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.ggw.setRadius(l.g(getContext(), R.dimen.tbds6));
        this.ggw.setConrers(5);
        this.ggw.setDrawCorner(true);
        this.ggx = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.ggr.setOnClickListener(this);
        this.ggs.setOnClickListener(this);
        this.ggt.setOnClickListener(this);
        this.ggv.setOnClickListener(this);
        this.ggx.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exN != null) {
            this.exN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exN != null) {
            this.exN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.exN != null) {
            this.exN.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.ggm != null) {
            this.mSkinType = i;
            this.ggn.setIsNight(this.mSkinType == 1);
            if (this.ggm.gfv) {
                if (this.ggm.gfu == 1) {
                    al.c(this.ggo, (int) R.drawable.label_topic_agree_red);
                    this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.ggm.gfu == 2) {
                    al.c(this.ggo, (int) R.drawable.label_topic_disagree_blue);
                    this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    al.c(this.ggo, (int) R.drawable.label_topic_eat_black);
                    this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            al.j(this.cbV, R.color.cp_cont_b);
            al.j(this.ggp, R.color.cp_cont_d);
            al.j(this.ggr, R.drawable.selector_topic_detail_comment_text_color);
            if (this.ggs != null && this.caF > 0) {
                this.ggs.setImageDrawable(al.getDrawable(this.caF));
            }
            this.ggq.onChangeSkinType(i);
            this.ggt.setTextColor(al.getColor(R.color.cp_cont_b));
            al.k(this.ggv, R.drawable.topic_original_bg_corner);
            al.j(this.ggx, R.color.cp_cont_d);
            this.exN.onChangeSkinType();
            al.l(this.mBottomLine, R.color.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String aC;
        int adm;
        AgreeData afl;
        if (cVar != null && cVar.threadData != null) {
            this.ggm = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bg bgVar = this.ggm.threadData;
            PostData aeT = bgVar.aeT();
            if (aeT != null) {
                if (this.ggm.source == 1) {
                    this.ggn.setData(bgVar, false, true);
                } else {
                    this.ggn.setData(bgVar, false, false);
                }
                this.ggn.setDefaultResource(R.drawable.icon_default_avatar100);
                this.ggn.setDefaultBgResource(R.color.cp_bg_line_e);
                this.ggn.setIsRound(true);
                this.ggn.setBorderWidth(2);
                this.ggn.setDrawBorder(true);
                this.ggn.setPageId(this.mContext.getUniqueId());
                if (this.ggm.gfv) {
                    this.ggo.setVisibility(0);
                    if (this.ggm.gfu == 1) {
                        this.ggo.setImageResource(R.drawable.label_topic_agree_red);
                        this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.ggm.gfu == 2) {
                        this.ggo.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.ggo.setImageResource(R.drawable.label_topic_eat_black);
                        this.ggn.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.ggo.setVisibility(8);
                }
                if (this.ggm.source == 1) {
                    name_show = aeT.adv().getName_show();
                    aC = ap.aC(aeT.getTime());
                    adm = aeT.cmy();
                } else {
                    name_show = bgVar.adv().getName_show();
                    aC = ap.aC(bgVar.getCreateTime());
                    adm = bgVar.adm();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cbV.setText(ap.j(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bgVar.adA())) {
                    this.ggp.setText(aC);
                } else {
                    this.ggp.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), ap.j(bgVar.adA(), 10, "..."), aC));
                }
                this.ggs.setImageDrawable(al.getDrawable(this.caF));
                String aN = ap.aN(adm);
                if (adm > 0) {
                    this.ggr.setVisibility(0);
                    this.ggr.setText(aN);
                } else {
                    this.ggr.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ggr.setVisibility(0);
                }
                if (this.ggm.source == 1) {
                    afl = aeT.afl();
                    afl.objType = 1;
                } else {
                    afl = bgVar.afl();
                    afl.objType = 3;
                }
                afl.threadId = bgVar.getTid();
                this.ggq.setData(afl);
                this.ggq.setTopicId(String.valueOf(this.ggm.topicId));
                if (this.ggm.source == 1) {
                    this.ggt.setVisibility(0);
                    this.ggt.setText(aeT.cmw());
                } else {
                    this.ggt.setVisibility(0);
                    int size = bgVar.adl().size();
                    if (StringUtils.isNull(bgVar.aeW().toString()) && size <= 0) {
                        this.ggt.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bgVar.adl(), false);
                        if (a != null) {
                            this.ggt.setText(a);
                        }
                    } else if (!StringUtils.isNull(bgVar.aeW().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bgVar.aeW().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.ggt.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.ggt.setVisibility(8);
                    }
                }
                if (this.ggm.source == 1) {
                    this.ggv.setVisibility(0);
                    this.ggu.setVisibility(8);
                    ArrayList<MediaData> adF = bgVar.adF();
                    String str = null;
                    String title = bgVar.getTitle();
                    if (v.Z(adF) != 0 && !v.aa(cVar.threadData.adF())) {
                        Iterator<MediaData> it = cVar.threadData.adF().iterator();
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
                    if (StringUtils.isNull(title)) {
                        this.ggv.setVisibility(8);
                    } else {
                        this.ggv.setVisibility(0);
                        this.ggx.setText(title);
                        if (StringUtils.isNull(str)) {
                            al.c(this.ggw, (int) R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.ggw.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.ggv.setVisibility(8);
                    this.ggu.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bg bgVar = cVar.threadData;
        ArrayList<MediaData> adF = bgVar.adF();
        if (i.abb().abf() && v.Z(adF) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.ggu.setVisibility(0);
                this.exN.setFromCDN(this.XJ);
                this.exN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bgVar);
                        } else {
                            d.this.aoV();
                        }
                    }
                });
                this.exN.setImageMediaList(linkedList);
                return;
            }
            this.ggu.setVisibility(8);
            return;
        }
        this.ggu.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.exN != null) {
            this.exN.setPageUniqueId(bdUniqueId);
        }
    }

    public void aoV() {
        if (this.ggm != null && this.ggm.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ggm.threadData, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.ggm.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ggm.threadData.adA());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.uS(this.ggm.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void buO() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.ggm.threadData.getTid()), String.format("%1$s", this.ggm.threadData.aeT().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.XJ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.adA(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.XJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.adA();
        historyMessage.postID = bgVar.adL();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggm != null && this.ggm.threadData != null) {
            if (view == this.ggt) {
                if (this.ggm.source == 1) {
                    buO();
                } else {
                    aoV();
                }
                xy("1");
            }
            if (view == this.ggr || view == this.ggs) {
                if (this.ggm.source == 1) {
                    buO();
                } else {
                    aoV();
                }
                xy("3");
                return;
            }
            aoV();
            xy("2");
        }
    }

    private void xy(String str) {
        TiebaStatic.log(new am("c13356").bT("obj_locate", str).bT("tid", this.ggm.threadData.getTid()).l("topic_id", this.ggm.topicId).bT("obj_type", String.valueOf(this.ggm.source)));
    }
}
