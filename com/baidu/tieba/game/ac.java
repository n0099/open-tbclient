package com.baidu.tieba.game;

import com.baidu.tbadk.game.GameInfoData;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Comparator<GameInfoData> {
    final /* synthetic */ ab aHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aHK = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(GameInfoData gameInfoData, GameInfoData gameInfoData2) {
        if (gameInfoData.getOrderTime() < gameInfoData2.getOrderTime()) {
            return -1;
        }
        if (gameInfoData.getOrderTime() > gameInfoData2.getOrderTime()) {
            return 1;
        }
        return 0;
    }
}
