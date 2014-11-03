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
public class bf extends BaseAdapter {
    final /* synthetic */ av aJj;

    private bf(av avVar) {
        this.aJj = avVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(av avVar, bf bfVar) {
        this(avVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.aJj.aIN;
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ff */
    public GameInfoData getItem(int i) {
        List list;
        List list2;
        if (i >= 0) {
            list = this.aJj.aIN;
            if (i < list.size()) {
                list2 = this.aJj.aIN;
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
        GameCenterActivity gameCenterActivity2;
        if (view == null) {
            gameCenterActivity2 = this.aJj.aIs;
            gameListBaseItem = new ae(gameCenterActivity2);
            gameListBaseItem.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        } else {
            gameListBaseItem = (GameListBaseItem) view;
        }
        GameInfoData item = getItem(i);
        if (item != null) {
            item.setRefId("1000201");
        }
        GameDownloadView downloadView = gameListBaseItem.getDownloadView();
        cVar = this.aJj.aJd;
        downloadView.setItemClickCallBack(cVar);
        GameDownloadView downloadView2 = gameListBaseItem.getDownloadView();
        dVar = this.aJj.aJe;
        downloadView2.setItemDownloadCallBack(dVar);
        gameCenterActivity = this.aJj.aIs;
        gameListBaseItem.a(gameCenterActivity.getUniqueId(), item);
        return gameListBaseItem;
    }
}
