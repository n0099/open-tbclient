package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.voice.h;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
/* loaded from: classes8.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    private ForumEmotionItemView iUw;
    private com.baidu.tieba.faceshop.forumpackage.data.c iUx;
    private NewFaceGroupDownloadModel iUy;
    private TbPageContext pageContext;

    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.iUw = (ForumEmotionItemView) view;
        this.pageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.faceshop.forumpackage.data.c cVar, com.baidu.tieba.faceshop.forumpackage.data.b bVar, a aVar, int i) {
        this.iUx = cVar;
        if (this.iUw == null || cVar == null) {
            return;
        }
        if (cVar.iUE != null || i == 0) {
            a(bVar, aVar, i);
            b(cVar.iUE);
            c(cVar.iUE);
            d(cVar.iUE);
            e(cVar.iUE);
        }
    }

    private void a(final com.baidu.tieba.faceshop.forumpackage.data.b bVar, final a aVar, int i) {
        String string;
        ViewGroup filterDropDownView = this.iUw.getFilterDropDownView();
        if (i == 0 && bVar != null) {
            Resources resources = this.iUw.getResources();
            TextView filterView = this.iUw.getFilterView();
            this.iUw.getHeaderView().setVisibility(0);
            filterDropDownView.setVisibility(0);
            if (bVar.cza() == 0) {
                string = resources.getString(R.string.forum_emotion_filter_all_bar);
            } else {
                string = resources.getString(R.string.forum_emotion_filter_my_bar);
            }
            filterView.setText(string);
            if (bVar.isExpanded()) {
                filterDropDownView.setVisibility(0);
            } else {
                filterDropDownView.setVisibility(8);
            }
            filterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bVar.setExpanded(!bVar.isExpanded());
                    if (aVar != null) {
                        aVar.cyZ();
                    }
                }
            });
            if (filterDropDownView.getChildCount() >= 2) {
                filterDropDownView.getChildAt(0).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bVar.setExpanded(false);
                        bVar.xV(0);
                        if (aVar != null) {
                            aVar.xU(bVar.cza());
                        }
                    }
                });
                filterDropDownView.getChildAt(1).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bVar.setExpanded(false);
                        bVar.xV(1);
                        if (aVar != null) {
                            aVar.xU(bVar.cza());
                        }
                    }
                });
                return;
            }
            return;
        }
        this.iUw.getHeaderView().setVisibility(8);
        filterDropDownView.setVisibility(8);
    }

    private void b(final ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.iUw.getListView().setVisibility(0);
            this.iUw.getListView().setAdapter((ListAdapter) this.iUw.getAdapter());
            this.iUw.getAdapter().setData(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
            this.iUw.getListView().setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.4
                @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
                public void a(AdapterView<?> adapterView, View view, int i, long j) {
                    ForumEmotionViewHolder.this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(ForumEmotionViewHolder.this.pageContext.getPageActivity(), forumEmotionPackageData.id, 0)));
                }
            });
            return;
        }
        this.iUw.getListView().setVisibility(4);
    }

    private void c(ForumEmotionPackageData forumEmotionPackageData) {
        TextView rankView = this.iUw.getRankView();
        if (forumEmotionPackageData != null) {
            rankView.setVisibility(0);
            if (forumEmotionPackageData.rank_num > 20) {
                rankView.setVisibility(8);
                return;
            } else if (forumEmotionPackageData.rank_num > 3) {
                rankView.setVisibility(0);
                rankView.setText(String.valueOf(forumEmotionPackageData.rank_num));
                ao.setBackgroundResource(rankView, R.drawable.bg_emotion_rank);
                return;
            } else {
                rankView.setVisibility(0);
                rankView.setText("");
                if (forumEmotionPackageData.rank_num == 3) {
                    ao.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num3);
                    return;
                } else if (forumEmotionPackageData.rank_num == 2) {
                    ao.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num2);
                    return;
                } else {
                    ao.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num1);
                    return;
                }
            }
        }
        rankView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumEmotionPackageData forumEmotionPackageData) {
        if (forumEmotionPackageData != null) {
            this.iUw.getDownloadNumView().setVisibility(0);
            this.iUw.getShareNumView().setVisibility(0);
            this.iUw.getTitleView().setVisibility(0);
            if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                this.iUw.getTitleView().setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
            } else {
                this.iUw.getTitleView().setText(forumEmotionPackageData.name);
            }
            this.iUw.getDownloadNumView().setText(String.format(h.getString(R.string.forum_emotion_down_num), at.numberUniform(forumEmotionPackageData.download)));
            this.iUw.getShareNumView().setText(String.format(h.getString(R.string.forum_emotion_share_num), at.numberUniform(forumEmotionPackageData.share)));
        } else {
            this.iUw.getTitleView().setVisibility(4);
            this.iUw.getDownloadNumView().setVisibility(4);
            this.iUw.getShareNumView().setVisibility(4);
        }
        this.iUw.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
        if (forumEmotionPackageData == null) {
            ao.setBackgroundColor(this.iUw, R.color.CAM_X0201);
        } else {
            this.iUw.setBackgroundColor(0);
        }
    }

    private void e(final ForumEmotionPackageData forumEmotionPackageData) {
        TextView downLoadView = this.iUw.getDownLoadView();
        if (forumEmotionPackageData == null) {
            downLoadView.setVisibility(4);
            return;
        }
        downLoadView.setVisibility(0);
        downLoadView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumEmotionViewHolder.this.f(forumEmotionPackageData);
            }
        });
        if (com.baidu.tieba.faceshop.a.cxd().IK("" + forumEmotionPackageData.id)) {
            downLoadView.setText(R.string.already_downloaded);
            downLoadView.setBackgroundDrawable(null);
            ao.setViewTextColor(downLoadView, R.color.CAM_X0109);
            downLoadView.setBackgroundDrawable(null);
            downLoadView.setEnabled(false);
            return;
        }
        switch (forumEmotionPackageData.status) {
            case 0:
            case 3:
                downLoadView.setText(R.string.download);
                ao.setViewTextColor(downLoadView, R.color.CAM_X0302);
                ao.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                downLoadView.setEnabled(true);
                return;
            case 1:
                downLoadView.setText(R.string.download);
                ao.setViewTextColor(downLoadView, R.color.CAM_X0302);
                ao.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                downLoadView.setEnabled(true);
                return;
            case 2:
                downLoadView.setBackgroundDrawable(null);
                ao.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setEnabled(false);
                return;
            case 4:
                downLoadView.setBackgroundDrawable(null);
                ao.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setText(R.string.face_package_has_delete);
                downLoadView.setEnabled(false);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final ForumEmotionPackageData forumEmotionPackageData) {
        if (bg.checkUpIsLogin(this.pageContext.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.iUy == null) {
                this.iUy = new NewFaceGroupDownloadModel();
            }
            this.iUw.getDownLoadView().setEnabled(false);
            this.iUy.a(Integer.toString(forumEmotionPackageData.id), true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionViewHolder.6
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(ForumEmotionViewHolder.this.pageContext.getPageActivity(), R.string.down_state_success);
                    ForumEmotionViewHolder.this.iUw.getDownLoadView().setText(R.string.already_downloaded);
                    ao.setViewTextColor(ForumEmotionViewHolder.this.iUw.getDownLoadView(), R.color.CAM_X0109);
                    ForumEmotionViewHolder.this.iUw.getDownLoadView().setBackgroundDrawable(null);
                    ForumEmotionViewHolder.this.iUw.getDownLoadView().setEnabled(false);
                    forumEmotionPackageData.download++;
                    if (ForumEmotionViewHolder.this.iUx != null && ForumEmotionViewHolder.this.iUx.iUE == forumEmotionPackageData) {
                        ForumEmotionViewHolder.this.d(forumEmotionPackageData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                    if (i > 0 && i < 100) {
                        l.showLongToast(ForumEmotionViewHolder.this.pageContext.getPageActivity(), h.getString(R.string.package_downloading_progress));
                    } else if (i >= 100) {
                        l.showLongToast(ForumEmotionViewHolder.this.pageContext.getPageActivity(), R.string.down_state_success);
                    }
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    l.showToast(ForumEmotionViewHolder.this.pageContext.getPageActivity(), R.string.download_error);
                    ForumEmotionViewHolder.this.iUw.getDownLoadView().setEnabled(true);
                }
            });
        }
    }
}
