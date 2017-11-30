package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaFrsStoryLiveGatherActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.e, com.baidu.tbadk.i.c> {
    private int bdT;
    private String bdU;
    private TbPageContext<?> mPageContext;

    static /* synthetic */ int b(c cVar) {
        int i = cVar.bdT;
        cVar.bdT = i + 1;
        return i;
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.e.aAg, bdUniqueId);
        this.bdT = 0;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public com.baidu.tbadk.i.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.c(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.entrance_frs_story_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.e eVar, com.baidu.tbadk.i.c cVar) {
        if (cVar == null || eVar == null) {
            return null;
        }
        a(cVar, (com.baidu.tbadk.data.e) getItem(i));
        return view;
    }

    private void a(com.baidu.tbadk.i.c cVar, final com.baidu.tbadk.data.e eVar) {
        if (cVar != null && eVar != null && !v.w(eVar.getList())) {
            final List<AlaLiveInfoCoreData> list = eVar.getList();
            cVar.mName.setText(this.mPageContext.getString(d.j.frs_game_gather_title));
            final HeadImageView frontImg = cVar.aFR.getFrontImg();
            final HeadImageView backImg = cVar.aFR.getBackImg();
            cVar.aFR.setLiveIngImgVisible(true);
            cVar.aFR.setOuterColor(d.C0082d.cp_link_tip_g);
            if (list.size() == 1) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = list.get(0);
                if (alaLiveInfoCoreData != null && alaLiveInfoCoreData.userInfo != null && !StringUtils.isNull(alaLiveInfoCoreData.userInfo.portrait)) {
                    frontImg.startLoad(alaLiveInfoCoreData.userInfo.portrait, 25, false);
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, 1, 0.33f, 1, 0.33f);
                scaleAnimation.setDuration(3000L);
                scaleAnimation.setRepeatCount(-1);
                scaleAnimation.setRepeatMode(2);
                backImg.setVisibility(8);
                frontImg.setIsRound(true);
                frontImg.startAnimation(scaleAnimation);
            } else {
                frontImg.setIsRound(true);
                backImg.setIsRound(true);
                final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setFillAfter(true);
                final ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, 1, 0.33f, 1, 0.33f);
                scaleAnimation2.setDuration(3000L);
                scaleAnimation2.setFillAfter(true);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.a.c.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        if (c.this.bdT >= list.size()) {
                            c.this.bdT = 0;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData2 = (AlaLiveInfoCoreData) list.get(c.b(c.this));
                        if (alaLiveInfoCoreData2 != null && alaLiveInfoCoreData2.userInfo != null && !StringUtils.isNull(alaLiveInfoCoreData2.userInfo.portrait)) {
                            c.this.bdU = alaLiveInfoCoreData2.userInfo.portrait;
                            backImg.startLoad(c.this.bdU, 25, false);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        frontImg.startAnimation(alphaAnimation);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.a.c.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (!StringUtils.isNull(c.this.bdU)) {
                            frontImg.setScaleX(1.0f);
                            frontImg.setScaleY(1.0f);
                            frontImg.startLoad(c.this.bdU, 25, false);
                            frontImg.setAlpha(1);
                            frontImg.startAnimation(scaleAnimation2);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.bdT = 0;
                int i = this.bdT;
                this.bdT = i + 1;
                AlaLiveInfoCoreData alaLiveInfoCoreData2 = list.get(i);
                if (alaLiveInfoCoreData2 != null && alaLiveInfoCoreData2.userInfo != null && !StringUtils.isNull(alaLiveInfoCoreData2.userInfo.portrait)) {
                    frontImg.startLoad(alaLiveInfoCoreData2.userInfo.portrait, 25, false);
                }
                frontImg.startAnimation(scaleAnimation2);
            }
            cVar.aFR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        view.setScaleX(0.8f);
                        view.setScaleY(0.8f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                    }
                    return view.onTouchEvent(motionEvent);
                }
            });
            cVar.aFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (eVar != null && !StringUtils.isNull(eVar.getFid())) {
                        TiebaStatic.log(new ak("c12548"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaFrsStoryLiveGatherActivityConfig(c.this.mPageContext.getPageActivity(), eVar.getFid(), eVar.getForumName())));
                    }
                }
            });
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
