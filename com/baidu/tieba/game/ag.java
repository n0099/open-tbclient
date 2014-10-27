package com.baidu.tieba.game;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.game.GameListBaseItem;
import com.baidu.tieba.game.view.GameDownloadView;
/* loaded from: classes.dex */
public class ag extends GameListBaseItem {
    private GameListBaseItem.SECOND_LINE_TYPE aHP;
    private TbClipImageView aHQ;
    private TextView aHR;
    private TextView aHS;
    private TextView aHT;
    private GameCenterCornerMark aHU;
    private View aHV;
    private GameDownloadView aHW;
    private TextView aHY;

    public ag(Context context, GameListBaseItem.SECOND_LINE_TYPE second_line_type) {
        super(context);
        this.aHP = second_line_type;
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ek().a(getItemContext(), com.baidu.tieba.w.game_list_item_tripple_recommend_lay, this, true);
        setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.game_center_list_item_bg));
        this.aHQ = (TbClipImageView) findViewById(com.baidu.tieba.v.game_list_item_image);
        this.aHR = (TextView) findViewById(com.baidu.tieba.v.game_list_item_game_name);
        this.aHS = (TextView) findViewById(com.baidu.tieba.v.game_list_item_user_num);
        this.aHY = (TextView) findViewById(com.baidu.tieba.v.game_list_item_reason);
        this.aHT = (TextView) findViewById(com.baidu.tieba.v.game_list_item_status_text);
        this.aHU = (GameCenterCornerMark) findViewById(com.baidu.tieba.v.shoufa_icon);
        this.aHV = findViewById(com.baidu.tieba.v.game_list_item_divider);
        this.aHW = (GameDownloadView) findViewById(com.baidu.tieba.v.game_list_item_download);
        this.aHQ.setDrawerType(1);
        this.aHQ.setRadius(com.baidu.adp.lib.util.m.c(getItemContext(), com.baidu.tieba.t.ds26));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.GameListBaseItem
    public void Hu() {
        super.Hu();
        if (getGameInfoData() != null) {
            String editorRec = getGameInfoData().getEditorRec();
            if (com.baidu.tieba.game.a.g.fy(editorRec) > 26) {
                editorRec = String.valueOf(com.baidu.tieba.game.a.g.g(editorRec, 0, 26)) + "...";
            }
            this.aHY.setText(editorRec);
        }
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
