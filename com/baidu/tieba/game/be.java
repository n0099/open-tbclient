package com.baidu.tieba.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.view.GameDownloadView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BaseAdapter {
    final /* synthetic */ av aIW;

    private be(av avVar) {
        this.aIW = avVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(av avVar, be beVar) {
        this(avVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.aIW.aIA;
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ff */
    public GameInfoData getItem(int i) {
        List list;
        List list2;
        if (i >= 0) {
            list = this.aIW.aIA;
            if (i < list.size()) {
                list2 = this.aIW.aIA;
                return (GameInfoData) list2.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        GameListBaseItem gameListBaseItem;
        com.baidu.tieba.game.view.c cVar;
        com.baidu.tieba.game.view.d dVar;
        GameCenterActivity gameCenterActivity;
        if (view == null) {
            gameCenterActivity = this.aIW.aIg;
            gameListBaseItem = new ae(gameCenterActivity);
            gameListBaseItem.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        } else {
            gameListBaseItem = (GameListBaseItem) view;
        }
        GameDownloadView downloadView = gameListBaseItem.getDownloadView();
        cVar = this.aIW.aIQ;
        downloadView.setItemClickCallBack(cVar);
        GameDownloadView downloadView2 = gameListBaseItem.getDownloadView();
        dVar = this.aIW.aIR;
        downloadView2.setItemDownloadCallBack(dVar);
        gameListBaseItem.setData(getItem(i));
        return gameListBaseItem;
    }
}
