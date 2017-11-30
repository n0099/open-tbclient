package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.d, com.baidu.tbadk.i.b> {
    private final long bdO;
    private final long bdP;
    private List<com.baidu.adp.widget.ListView.f> bdQ;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.d.aAb, bdUniqueId);
        this.bdO = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.bdP = 2000L;
        this.mPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.bdQ = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public com.baidu.tbadk.i.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.entrance_frs_story_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.d dVar, com.baidu.tbadk.i.b bVar) {
        if (bVar == null || dVar == null) {
            return null;
        }
        a(bVar, (com.baidu.tbadk.data.d) getItem(i), i);
        return view;
    }

    private void a(com.baidu.tbadk.i.b bVar, final com.baidu.tbadk.data.d dVar, int i) {
        if (bVar != null && dVar != null && dVar.aAc.userInfo != null && !StringUtils.isNull(dVar.aAc.userInfo.portrait)) {
            bVar.mName.setText(dVar.aAc.userInfo.userName);
            bVar.aFR.setLiveIngImgVisible(true);
            bVar.aFR.getFrontImg().setIsRound(true);
            bVar.aFR.getFrontImg().startLoad(dVar.aAc.userInfo.portrait, 25, false);
            bVar.aFR.setOuterColor(d.C0082d.cp_link_tip_g);
            if (!dVar.aAd) {
                if (!v.w(this.bdQ)) {
                    bVar.aFR.getFrontImg().startAnimation(gy(i));
                    dVar.aAd = true;
                    dVar.aAe = System.currentTimeMillis();
                } else {
                    return;
                }
            }
            bVar.aFR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.b.1
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
            bVar.aFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData;
                    if (dVar != null && (alaLiveInfoCoreData = dVar.aAc) != null) {
                        TiebaStatic.log(new ak("c12546").ac("obj_param1", alaLiveInfoCoreData.userName));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(b.this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB, TbadkCoreApplication.getCurrentAccount(), false, "");
                        alaLiveRoomActivityConfig.setIsForbidVerticalChangeLiveRoom(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig));
                    }
                }
            });
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private ScaleAnimation gy(int i) {
        long currentTimeMillis;
        long j;
        float f;
        float f2;
        if (i == com.baidu.tbadk.data.d.aAf) {
            j = 0;
            f = 1.4f;
            f2 = 1.0f;
        } else {
            Object obj = null;
            Object obj2 = null;
            if (i > 0) {
                obj = (com.baidu.adp.widget.ListView.f) this.bdQ.get(i - 1);
            }
            if (i < this.bdQ.size() - 1) {
                obj2 = (com.baidu.adp.widget.ListView.f) this.bdQ.get(i + 1);
            }
            if (obj != null && (obj instanceof com.baidu.tbadk.data.d)) {
                com.baidu.tbadk.data.d dVar = (com.baidu.tbadk.data.d) obj;
                if (dVar.aAd) {
                    currentTimeMillis = dVar.aAe;
                } else if (obj2 != null && (obj2 instanceof com.baidu.tbadk.data.d)) {
                    com.baidu.tbadk.data.d dVar2 = (com.baidu.tbadk.data.d) obj2;
                    if (dVar2.aAd) {
                        currentTimeMillis = dVar2.aAe;
                    } else {
                        currentTimeMillis = System.currentTimeMillis();
                    }
                } else if (obj2 != null && (obj2 instanceof com.baidu.tbadk.data.d)) {
                    currentTimeMillis = 0;
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) % TbConfig.NOTIFY_SOUND_INTERVAL;
            if (((int) ((System.currentTimeMillis() - currentTimeMillis) / TbConfig.NOTIFY_SOUND_INTERVAL)) % 2 == 0) {
                if (currentTimeMillis2 < 2000) {
                    j = 2000 - currentTimeMillis2;
                    f = 1.4f;
                    f2 = 1.0f;
                } else {
                    j = 7000 - currentTimeMillis2;
                    f = 1.0f;
                    f2 = 1.4f;
                }
            } else if (currentTimeMillis2 < 2000) {
                j = 2000 - currentTimeMillis2;
                f = 1.0f;
                f2 = 1.4f;
            } else {
                j = 7000 - currentTimeMillis2;
                f = 1.4f;
                f2 = 1.0f;
            }
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f, f2, f, 1, 0.33f, 1, 0.33f);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setDuration(TbConfig.NOTIFY_SOUND_INTERVAL);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setStartOffset(j);
        return scaleAnimation;
    }
}
