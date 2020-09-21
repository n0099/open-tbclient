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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes22.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel ezi;
    private int gPj;
    private int hWf;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gPj = 0;
        this.hWf = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bg.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.ezi.gd(jVar.getForumName(), forumId);
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
        if (this.ezi == null) {
            bHV();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.cnA() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.cp_cont_d);
            v cnA = jVar.cnA();
            if (TbadkCoreApplication.isLogin()) {
                if (cnA.isLike() == 1) {
                    kVar.hWj.setVisibility(8);
                    kVar.hWk.setVisibility(0);
                    kVar.hWk.setText(R.string.mydegree);
                    ap.setImageResource(kVar.hVi, BitmapHelper.getSmallGradeResourceIdNew(cnA.dxT()));
                    if (StringUtils.isNull(cnA.getLevelName())) {
                        kVar.hVj.setVisibility(8);
                    } else {
                        kVar.hVj.setText(cnA.getLevelName());
                        kVar.hVj.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cnA.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cnA.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.esz.setText(spannableStringBuilder);
                    kVar.esz.setVisibility(0);
                    kVar.hWp.setVisibility(0);
                    kVar.hWq.setVisibility(0);
                } else {
                    kVar.hWj.setVisibility(0);
                    kVar.hWk.setVisibility(8);
                    kVar.hVi.setVisibility(8);
                    kVar.hVj.setVisibility(8);
                    kVar.esz.setVisibility(8);
                    kVar.hWp.setVisibility(8);
                    kVar.hWq.setVisibility(8);
                }
            } else {
                kVar.hWj.setVisibility(8);
                kVar.hWk.setVisibility(8);
                kVar.hVi.setVisibility(8);
                kVar.hVj.setVisibility(8);
                kVar.esz.setVisibility(8);
                kVar.hWp.setVisibility(8);
                kVar.hWq.setVisibility(8);
            }
            kVar.hWj.setTag(Integer.valueOf(i));
            kVar.hVj.setTag(Integer.valueOf(i));
            kVar.hVj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.hWm, R.color.cp_bg_line_d);
            ap.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(kVar.hWn, R.color.cp_bg_line_c);
            ap.setBackgroundResource(kVar.hWj, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.hWj, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.hWk, R.color.cp_cont_b, 1);
            ap.setViewTextColor(kVar.hVj, R.color.cp_cont_d, 1);
            ap.setViewTextColor(kVar.hWo, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(kVar.hWp, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.hWq, R.color.cp_bg_line_c);
            if (this.gPj != cnA.dxT() || this.hWf != cnA.getCurScore()) {
                this.gPj = cnA.dxT();
                this.hWf = cnA.getCurScore();
                kVar.hWp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, xe(this.gPj)));
                float f = 0.0f;
                this.hWf = cnA.getCurScore();
                if (this.hWf > cnA.getLevelupScore()) {
                    this.hWf = cnA.getLevelupScore();
                }
                if (cnA.getLevelupScore() != 0) {
                    f = this.hWf / cnA.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.hWp, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bHV() {
        if (this.mPageContext != null) {
            this.ezi = new LikeModel(this.mPageContext);
            this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof v) || i.this.ezi.getErrorCode() != 0) {
                        if (AntiHelper.bC(i.this.ezi.getErrorCode(), i.this.ezi.getErrorString())) {
                            AntiHelper.bh(i.this.mPageContext.getPageActivity(), i.this.ezi.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.ezi.getErrorString());
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

    private int[] xe(int i) {
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
