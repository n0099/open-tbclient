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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.d, com.baidu.tbadk.j.b> {
    private final long bav;
    private final long baw;
    private List<com.baidu.adp.widget.ListView.f> bax;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.d.azs, bdUniqueId);
        this.bav = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.baw = 2000L;
        this.mPageContext = tbPageContext;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.bax = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public com.baidu.tbadk.j.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.b(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.entrance_frs_story_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.d dVar, com.baidu.tbadk.j.b bVar) {
        if (bVar == null || dVar == null) {
            return null;
        }
        a(bVar, (com.baidu.tbadk.data.d) getItem(i), i);
        return view;
    }

    private void a(com.baidu.tbadk.j.b bVar, final com.baidu.tbadk.data.d dVar, int i) {
        if (bVar != null && dVar != null && dVar.azt.userInfo != null && !StringUtils.isNull(dVar.azt.userInfo.portrait)) {
            bVar.mName.setText(dVar.azt.userInfo.userName);
            bVar.aFi.setLiveIngImgVisible(true);
            bVar.aFi.getFrontImg().setIsRound(true);
            bVar.aFi.getFrontImg().startLoad(dVar.azt.userInfo.portrait, 25, false);
            bVar.aFi.setOuterColor(d.C0080d.cp_link_tip_g);
            if (!dVar.azu) {
                if (!v.v(this.bax)) {
                    bVar.aFi.getFrontImg().startAnimation(go(i));
                    dVar.azu = true;
                    dVar.azv = System.currentTimeMillis();
                } else {
                    return;
                }
            }
            bVar.aFi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.b.1
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
            bVar.aFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData;
                    if (dVar != null && (alaLiveInfoCoreData = dVar.azt) != null) {
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

    private ScaleAnimation go(int i) {
        long currentTimeMillis;
        long j;
        float f;
        float f2;
        if (i == com.baidu.tbadk.data.d.azw) {
            j = 0;
            f = 1.4f;
            f2 = 1.0f;
        } else {
            Object obj = null;
            Object obj2 = null;
            if (i > 0) {
                obj = (com.baidu.adp.widget.ListView.f) this.bax.get(i - 1);
            }
            if (i < this.bax.size() - 1) {
                obj2 = (com.baidu.adp.widget.ListView.f) this.bax.get(i + 1);
            }
            if (obj != null && (obj instanceof com.baidu.tbadk.data.d)) {
                com.baidu.tbadk.data.d dVar = (com.baidu.tbadk.data.d) obj;
                if (dVar.azu) {
                    currentTimeMillis = dVar.azv;
                } else if (obj2 != null && (obj2 instanceof com.baidu.tbadk.data.d)) {
                    com.baidu.tbadk.data.d dVar2 = (com.baidu.tbadk.data.d) obj2;
                    if (dVar2.azu) {
                        currentTimeMillis = dVar2.azv;
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
