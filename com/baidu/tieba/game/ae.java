package com.baidu.tieba.game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.game.GameListBaseItem;
import com.baidu.tieba.game.view.GameDownloadView;
/* loaded from: classes.dex */
public class ae extends GameListBaseItem {
    private GameListBaseItem.SECOND_LINE_TYPE aHP;
    private TbClipImageView aHQ;
    private TextView aHR;
    private TextView aHS;
    private TextView aHT;
    private GameCenterCornerMark aHU;
    private View aHV;
    private GameDownloadView aHW;

    public ae(Context context) {
        this(context, null);
    }

    public ae(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHP = GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS;
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ek().a(getItemContext(), com.baidu.tieba.w.game_list_item_double_lay, this, true);
        this.aHQ = (TbClipImageView) findViewById(com.baidu.tieba.v.game_list_item_image);
        this.aHR = (TextView) findViewById(com.baidu.tieba.v.game_list_item_game_name);
        this.aHS = (TextView) findViewById(com.baidu.tieba.v.game_list_item_user_num);
        this.aHT = (TextView) findViewById(com.baidu.tieba.v.game_list_item_status_text);
        this.aHU = (GameCenterCornerMark) findViewById(com.baidu.tieba.v.shoufa_icon);
        this.aHV = findViewById(com.baidu.tieba.v.game_list_item_divider);
        this.aHW = (GameDownloadView) findViewById(com.baidu.tieba.v.game_list_item_download);
        this.aHQ.setDrawerType(1);
        this.aHQ.setRadius(com.baidu.adp.lib.util.m.c(getItemContext(), com.baidu.tieba.t.ds26));
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TbClipImageView getGameImage() {
        return this.aHQ;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected GameCenterCornerMark getGameCornerMark() {
        return this.aHU;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameNameTextView() {
        return this.aHR;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameIconTextView() {
        return this.aHT;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameInfoTextView() {
        return this.aHS;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected GameListBaseItem.SECOND_LINE_TYPE getSecondLineType() {
        return this.aHP;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected View getBottomLine() {
        return this.aHV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.GameListBaseItem
    public GameDownloadView getDownloadView() {
        return this.aHW;
    }
}
