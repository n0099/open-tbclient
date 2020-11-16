package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> eGu;
    private LikeModel eYI;
    private List<FeedForumData> iWc;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.eGu.getOrignalPage()).checkUpIsLogin()) {
                        e.this.eYI.gp(feedForumData.getForumName(), feedForumData.getForumId());
                        ar arVar = new ar("c10048");
                        arVar.dR("fid", feedForumData.getForumId());
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(arVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.eGu.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new ar("c10050").dR("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d ikM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(e.this.eYI.getErrorCode(), e.this.eYI.getErrorString())) {
                AntiHelper.bj(e.this.eGu.getPageActivity(), e.this.eYI.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.eYI.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.eYI.getErrorString());
                }
            } else {
                v vVar = (v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.eGu = tbPageContext;
        this.eYI = new LikeModel(tbPageContext);
        this.eYI.setLoadDataCallBack(this.ikM);
    }

    public void setData(List<FeedForumData> list) {
        this.iWc = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iWc != null) {
            return this.iWc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iWc != null) {
            return this.iWc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.iWk.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.fTg.setOnClickListener(this.mOnClickListener);
        bVar.iWh.setPlaceHolder(1);
        bVar.iWh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.iWh.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.iWi.setText(String.format(this.eGu.getPageActivity().getString(R.string.attention_post_count), zZ(feedForumData.getMemberCount()), zZ(feedForumData.getPostNum())));
        bVar.iWj.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.iWk.setClickable(true);
            bVar.iWk.setOnClickListener(this.mOnClickListener);
            bVar.iWk.setEnabled(true);
            bVar.iWk.aP(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ajv != this.mSkinType) {
            ap.setBackgroundResource(bVar.fTg, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(bVar.iWi, R.color.CAM_X0108, 1);
            ap.setViewTextColor(bVar.iWj, R.color.CAM_X0305, 1);
            if (bVar.mDivider != null) {
                ap.setBackgroundColor(bVar.mDivider, R.color.CAM_X0204);
            }
            bVar.ajv = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.iWk != null) {
            bVar.iWk.aP(true);
            bVar.iWk.setEnabled(false);
        }
    }

    private String zZ(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    public void a(List<FeedForumData> list, v vVar) {
        if (list != null && list.size() > 0 && vVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(vVar.getFid())) {
                    feedForumData.setIsLike(vVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
