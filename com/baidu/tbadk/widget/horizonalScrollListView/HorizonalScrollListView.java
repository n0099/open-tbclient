package com.baidu.tbadk.widget.horizonalScrollListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout cSf;
    private final ArrayList<a> cSg;
    private View.OnClickListener cSh;
    private View cSi;
    private String cSj;
    private String cSk;
    private CustomMessageListener cSl;
    private CustomMessageListener cSm;
    private View.OnClickListener cSn;
    private View.OnClickListener cSo;
    private String mFrom;
    private int mSkinType;
    private BdUniqueId mTag;
    private TbPageContext<?> mTbPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
        if (this.mTag != null) {
            if (this.cSm != null) {
                this.cSm.setTag(this.mTag);
            }
            if (this.cSl != null) {
                this.cSl.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setStatKey(String str, String str2) {
        this.cSj = str;
        this.cSk = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cSg = new ArrayList<>();
        this.mSkinType = 3;
        this.cSh = null;
        this.mTag = null;
        this.cSl = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cSm = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSj)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cSj).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cSo = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSk)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cSk).bS("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSg = new ArrayList<>();
        this.mSkinType = 3;
        this.cSh = null;
        this.mTag = null;
        this.cSl = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cSm = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSj)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cSj).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cSo = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSk)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cSk).bS("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSg = new ArrayList<>();
        this.mSkinType = 3;
        this.cSh = null;
        this.mTag = null;
        this.cSl = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cSm = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSj)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cSj).O("obj_type", 1).bS("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aS(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dY(str, valueOf);
                    }
                }
            }
        };
        this.cSo = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cSk)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cSk).bS("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.cSf = new LinearLayout(context);
        this.cSf.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cSf.setOrientation(0);
        addView(this.cSf);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = v.getCount(this.cSg);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.getItem(this.cSg, i);
                    if (aVar != null) {
                        this.cSf.removeView(aVar.getView());
                    }
                    this.cSg.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.getItem(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.getItem(this.cSg, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.cSg.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cSf.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.cSg.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cSl);
            this.mTbPageContext.registerListener(this.cSm);
            if (getTag() != null) {
                this.cSl.setTag(getTag());
                this.cSm.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cSi = aVar.getView();
            aVar.cSw.setVisibility(8);
            aVar.cSu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cSv.setVisibility(8);
            aVar.cSt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.cSt, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.cSu, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.cSt, R.drawable.selector_load_more_bg);
            this.cSi.setClickable(true);
            this.cSi.setOnClickListener(this.cSh);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cSh = onClickListener;
    }

    public View getLastItemView() {
        return this.cSi;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cSw.setClickable(true);
            aVar2.cSw.setOnClickListener(this.cSn);
            view.setClickable(true);
            view.setOnClickListener(this.cSo);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cSt.setTag(aVar.forumAvatar);
            aVar2.cSt.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cSu.setText(aVar.forumName);
            aVar2.cSu.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cSv.setDefaultBgResource(0);
            aVar2.cSv.setDefaultResource(0);
            aVar2.cSw.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cSw.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.cSw, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cSv.setVisibility(0);
                    am.setImageResource(aVar2.cSv, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cSv.setVisibility(0);
                    am.setImageResource(aVar2.cSv, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cSv.setVisibility(0);
                    am.setImageResource(aVar2.cSv, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cSv.setVisibility(8);
                    break;
            }
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ew(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cSg.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cSi != null) {
                BarImageView barImageView = (BarImageView) this.cSi.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.cSi.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.cSg);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.getItem(this.cSg, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.cSv, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.cSv, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.cSv, R.drawable.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.cSw.getTag(R.id.forum_follow) != null && (aVar.cSw.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.cSw, ((Boolean) aVar.cSw.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.cSu, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cSg.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cSu.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cSw;
                if (((Long) next.cSu.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cSt;
        public TextView cSu;
        public TbImageView cSv;
        public EntelechyUserLikeButton cSw;

        public a(View view) {
            super(view);
            this.cSt = null;
            this.cSu = null;
            this.cSv = null;
            this.cSw = null;
            this.cSt = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.cSt.setGifIconSupport(false);
            this.cSu = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.cSv = (TbImageView) view.findViewById(R.id.hot_rank);
            this.cSw = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
