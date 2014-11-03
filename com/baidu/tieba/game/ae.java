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
    private GameListBaseItem.SECOND_LINE_TYPE aHZ;
    private TbClipImageView aIa;
    private TextView aIb;
    private TextView aIc;
    private TextView aId;
    private GameCenterCornerMark aIe;
    private View aIf;
    private GameDownloadView aIg;

    public ae(Context context) {
        this(context, null);
    }

    public ae(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHZ = GameListBaseItem.SECOND_LINE_TYPE.TYPE_ALL_DOWNLOADS;
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ek().a(getItemContext(), com.baidu.tieba.w.game_list_item_double_lay, this, true);
        this.aIa = (TbClipImageView) findViewById(com.baidu.tieba.v.game_list_item_image);
        this.aIb = (TextView) findViewById(com.baidu.tieba.v.game_list_item_game_name);
        this.aIc = (TextView) findViewById(com.baidu.tieba.v.game_list_item_user_num);
        this.aId = (TextView) findViewById(com.baidu.tieba.v.game_list_item_status_text);
        this.aIe = (GameCenterCornerMark) findViewById(com.baidu.tieba.v.shoufa_icon);
        this.aIf = findViewById(com.baidu.tieba.v.game_list_item_divider);
        this.aIg = (GameDownloadView) findViewById(com.baidu.tieba.v.game_list_item_download);
        this.aIa.setDrawerType(1);
        this.aIa.setRadius(com.baidu.adp.lib.util.m.c(getItemContext(), com.baidu.tieba.t.ds26));
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TbClipImageView getGameImage() {
        return this.aIa;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected GameCenterCornerMark getGameCornerMark() {
        return this.aIe;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameNameTextView() {
        return this.aIb;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameIconTextView() {
        return this.aId;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected TextView getGameInfoTextView() {
        return this.aIc;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected GameListBaseItem.SECOND_LINE_TYPE getSecondLineType() {
        return this.aHZ;
    }

    @Override // com.baidu.tieba.game.GameListBaseItem
    protected View getBottomLine() {
        return this.aIf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.GameListBaseItem
    public GameDownloadView getDownloadView() {
        return this.aIg;
    }
}
