package com.baidu.tieba.forumMember.member;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes22.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel eYI;
    private int hvH;
    private int iEn;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hvH = 0;
        this.iEn = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bh.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.eYI.gp(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_TBTITLE_ACTIVITY, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public k c(ViewGroup viewGroup) {
        if (this.eYI == null) {
            bPc();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.cwj() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.CAM_X0109);
            v cwj = jVar.cwj();
            if (TbadkCoreApplication.isLogin()) {
                if (cwj.isLike() == 1) {
                    kVar.iEr.setVisibility(8);
                    kVar.iEs.setVisibility(0);
                    kVar.iEs.setText(R.string.mydegree);
                    ap.setImageResource(kVar.iDr, BitmapHelper.getSmallGradeResourceIdNew(cwj.dHf()));
                    if (StringUtils.isNull(cwj.getLevelName())) {
                        kVar.iDs.setVisibility(8);
                    } else {
                        kVar.iDs.setText(cwj.getLevelName());
                        kVar.iDs.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cwj.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cwj.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eRX.setText(spannableStringBuilder);
                    kVar.eRX.setVisibility(0);
                    kVar.iEx.setVisibility(0);
                    kVar.iEy.setVisibility(0);
                } else {
                    kVar.iEr.setVisibility(0);
                    kVar.iEs.setVisibility(8);
                    kVar.iDr.setVisibility(8);
                    kVar.iDs.setVisibility(8);
                    kVar.eRX.setVisibility(8);
                    kVar.iEx.setVisibility(8);
                    kVar.iEy.setVisibility(8);
                }
            } else {
                kVar.iEr.setVisibility(8);
                kVar.iEs.setVisibility(8);
                kVar.iDr.setVisibility(8);
                kVar.iDs.setVisibility(8);
                kVar.eRX.setVisibility(8);
                kVar.iEx.setVisibility(8);
                kVar.iEy.setVisibility(8);
            }
            kVar.iEr.setTag(Integer.valueOf(i));
            kVar.iDs.setTag(Integer.valueOf(i));
            kVar.iDs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.iEu, R.color.CAM_X0201);
            ap.setBackgroundColor(kVar.mDivider, R.color.CAM_X0204);
            ap.setBackgroundColor(kVar.iEv, R.color.CAM_X0204);
            ap.setBackgroundResource(kVar.iEr, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.iEr, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.iEs, R.color.CAM_X0105, 1);
            ap.setViewTextColor(kVar.iDs, R.color.CAM_X0109, 1);
            ap.setViewTextColor(kVar.iEw, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(kVar.iEx, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.iEy, R.color.CAM_X0204);
            if (this.hvH != cwj.dHf() || this.iEn != cwj.getCurScore()) {
                this.hvH = cwj.dHf();
                this.iEn = cwj.getCurScore();
                kVar.iEx.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yO(this.hvH)));
                float f = 0.0f;
                this.iEn = cwj.getCurScore();
                if (this.iEn > cwj.getLevelupScore()) {
                    this.iEn = cwj.getLevelupScore();
                }
                if (cwj.getLevelupScore() != 0) {
                    f = this.iEn / cwj.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.iEx, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bPc() {
        if (this.mPageContext != null) {
            this.eYI = new LikeModel(this.mPageContext);
            this.eYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof v) || i.this.eYI.getErrorCode() != 0) {
                        if (AntiHelper.bP(i.this.eYI.getErrorCode(), i.this.eYI.getErrorString())) {
                            AntiHelper.bj(i.this.mPageContext.getPageActivity(), i.this.eYI.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.eYI.getErrorString());
                            return;
                        }
                    }
                    v vVar = (v) obj;
                    vVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            });
        }
    }

    private int[] yO(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }
}
