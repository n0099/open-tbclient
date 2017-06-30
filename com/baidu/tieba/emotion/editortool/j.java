package com.baidu.tieba.emotion.editortool;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.GridView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ EmotionTabContentView bRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(EmotionTabContentView emotionTabContentView, int i) {
        super(i);
        this.bRr = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        EmotionTabContentView.b bVar;
        EmotionTabContentView.b bVar2;
        EmotionTabContentView.b bVar3;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        w wVar;
        List list2;
        List list3;
        int i = 0;
        switch (customResponsedMessage.getCmd()) {
            case CmdConfigCustom.CMD_USER_COLLECT_EMOTION_CHANGE /* 2921028 */:
                EmotionTabContentView emotionTabContentView = this.bRr;
                list = this.bRr.bRj;
                emotionTabContentView.ag(new ArrayList(list));
                bVar = this.bRr.bQX;
                if (bVar != null) {
                    bVar2 = this.bRr.bQX;
                    bVar2.notifyDataSetChanged();
                    if (this.bRr.bRm >= 0) {
                        int i2 = this.bRr.bRm;
                        list2 = this.bRr.bRj;
                        if (i2 < list2.size()) {
                            list3 = this.bRr.bRj;
                            if (((com.baidu.tbadk.editortools.emotiontool.c) list3.get(this.bRr.bRm)).CV() != EmotionGroupType.USER_COLLECT) {
                                return;
                            }
                        }
                    }
                    bVar3 = this.bRr.bQX;
                    if (bVar3 != null) {
                        if (this.bRr.currentPosition >= 0 && this.bRr.currentPosition < this.bRr.bRk.size()) {
                            this.bRr.bRi = (w) this.bRr.bRk.get(this.bRr.currentPosition);
                            wVar = this.bRr.bRi;
                            int aag = wVar.aag();
                            this.bRr.aCq.setCount(aag);
                            this.bRr.aCq.setVisibility(aag > 1 ? 0 : 4);
                        }
                        viewPager = this.bRr.mViewPager;
                        if (viewPager == null) {
                            return;
                        }
                        while (true) {
                            try {
                                int i3 = i;
                                viewPager2 = this.bRr.mViewPager;
                                if (i3 < viewPager2.getChildCount()) {
                                    viewPager3 = this.bRr.mViewPager;
                                    View childAt = viewPager3.getChildAt(i3);
                                    if (childAt != null && (childAt instanceof GridView)) {
                                        GridView gridView = (GridView) childAt;
                                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof EmotionTabContentView.a)) {
                                            EmotionTabContentView.a aVar = (EmotionTabContentView.a) gridView.getAdapter();
                                            int index = aVar.aaa().getIndex();
                                            if (index >= 0 && index < this.bRr.bRk.size()) {
                                                aVar.a((w) this.bRr.bRk.get(index));
                                                aVar.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                    i = i3 + 1;
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
    }
}
