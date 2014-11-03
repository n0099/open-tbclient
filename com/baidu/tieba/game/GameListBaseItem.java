package com.baidu.tieba.game;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.game.view.GameDownloadView;
/* loaded from: classes.dex */
public abstract class GameListBaseItem extends RelativeLayout {
    private String aHW;
    private boolean aHX;
    private GameInfoData aHj;
    private Context mContext;

    /* loaded from: classes.dex */
    public enum SECOND_LINE_TYPE {
        TYPE_ALL_DOWNLOADS,
        TYPE_DAY_DOWNLOADS,
        TYPE_CATEGORY;

        /* JADX DEBUG: Replace access to removed values field (aHY) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SECOND_LINE_TYPE[] valuesCustom() {
            SECOND_LINE_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            SECOND_LINE_TYPE[] second_line_typeArr = new SECOND_LINE_TYPE[length];
            System.arraycopy(valuesCustom, 0, second_line_typeArr, 0, length);
            return second_line_typeArr;
        }
    }

    protected abstract View getBottomLine();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract GameDownloadView getDownloadView();

    protected abstract GameCenterCornerMark getGameCornerMark();

    protected abstract TextView getGameIconTextView();

    protected abstract TbClipImageView getGameImage();

    protected abstract TextView getGameInfoTextView();

    protected abstract TextView getGameNameTextView();

    protected abstract SECOND_LINE_TYPE getSecondLineType();

    public GameListBaseItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHX = false;
        this.mContext = context;
    }

    public GameListBaseItem(Context context) {
        super(context);
        this.aHX = false;
        this.mContext = context;
    }

    public GameInfoData getGameInfoData() {
        return this.aHj;
    }

    public Context getItemContext() {
        return this.mContext;
    }

    public void setOnItemDownloadClick(com.baidu.tieba.game.view.c cVar) {
        if (getDownloadView() != null) {
            getDownloadView().setItemClickCallBack(cVar);
        }
    }

    public void setGameDownloadedCallBack(com.baidu.tieba.game.view.d dVar) {
        if (getDownloadView() != null) {
            getDownloadView().setItemDownloadCallBack(dVar);
        }
    }

    public final void setGameInfoStr(String str) {
        this.aHX = true;
        this.aHW = str;
    }

    public final void setBottomLineVisible(boolean z) {
        View bottomLine = getBottomLine();
        if (bottomLine != null) {
            if (z) {
                bottomLine.setVisibility(0);
            } else {
                bottomLine.setVisibility(8);
            }
        }
    }

    protected String getGameInfoString() {
        String format;
        if (this.aHj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String packageSize = this.aHj.getPackageSize();
        if (!TextUtils.isEmpty(packageSize)) {
            sb.append(packageSize);
            sb.append("M");
        }
        SECOND_LINE_TYPE secondLineType = getSecondLineType();
        if (secondLineType == SECOND_LINE_TYPE.TYPE_CATEGORY) {
            format = this.aHj.getCategoryName();
        } else if (secondLineType == SECOND_LINE_TYPE.TYPE_DAY_DOWNLOADS) {
            int dayDownloads = this.aHj.getDayDownloads();
            if (dayDownloads <= 0) {
                format = "";
            } else {
                format = String.format(this.mContext.getResources().getString(com.baidu.tieba.y.game_list_item_day_download), com.baidu.tieba.game.a.g.fj(dayDownloads));
            }
        } else {
            int playerNum = this.aHj.getPlayerNum();
            if (playerNum <= 0) {
                format = "";
            } else {
                format = String.format(this.mContext.getResources().getString(com.baidu.tieba.y.game_center_good_downloaded_num), com.baidu.tieba.game.a.g.fj(playerNum));
            }
        }
        if (!TextUtils.isEmpty(format)) {
            if (!TextUtils.isEmpty(packageSize)) {
                sb.append("/");
            }
            sb.append(format);
        }
        return sb.toString();
    }

    private boolean fs(String str) {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(str, false);
    }

    private int ft(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return this.mContext.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public int p(GameInfoData gameInfoData) {
        if (gameInfoData.getMark() == 1) {
            return 1;
        }
        if (gameInfoData.getMark() == 0) {
            return 0;
        }
        int f = com.baidu.adp.lib.g.c.f(gameInfoData.getVersion(), 0);
        int ft = ft(gameInfoData.getPackageName());
        if (gameInfoData.getGameType() == 1 && f > 0 && ft > 0 && ft < f) {
            return 3;
        }
        if (gameInfoData.getMark() == 2) {
            long deadline = gameInfoData.getDeadline();
            long currentTimeMillis = System.currentTimeMillis();
            if (!fs(gameInfoData.getGameId()) && deadline * 1000 > currentTimeMillis) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(BdUniqueId bdUniqueId) {
        if (this.aHj != null) {
            if (getGameImage() != null) {
                getGameImage().setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                getGameImage().setSupportNoImage(false);
                String iconUrl = this.aHj.getIconUrl();
                if (TextUtils.isEmpty(iconUrl)) {
                    getGameImage().reset();
                } else {
                    getGameImage().c(iconUrl, 10, false);
                }
            }
            if (getGameCornerMark() != null) {
                if (!TextUtils.isEmpty(this.aHj.getSecretKey())) {
                    getGameCornerMark().setVisibility(0);
                    getGameCornerMark().setText(this.aHj.getSecretKey());
                    getGameCornerMark().setBgColorTag(this.aHj.getSuperscriptColor());
                    getGameCornerMark().invalidate();
                } else {
                    getGameCornerMark().setVisibility(8);
                }
            }
            if (getGameNameTextView() != null) {
                String gameName = this.aHj.getGameName();
                if (com.baidu.tieba.game.a.g.fy(gameName) > 14) {
                    gameName = String.valueOf(com.baidu.tieba.game.a.g.g(gameName, 0, 14)) + "...";
                }
                getGameNameTextView().setText(gameName);
            }
            if (getGameInfoTextView() != null) {
                if (this.aHX) {
                    getGameInfoTextView().setText(this.aHW);
                } else if (this.aHj.getGameType() == 2) {
                    int playerNum = this.aHj.getPlayerNum();
                    if (playerNum < 0) {
                        playerNum = 0;
                    }
                    getGameInfoTextView().setText(playerNum == 0 ? "" : String.format(this.mContext.getResources().getString(com.baidu.tieba.y.game_center_player_num), com.baidu.tieba.game.a.g.fj(playerNum)));
                } else {
                    getGameInfoTextView().setText(getGameInfoString());
                }
            }
            if (getDownloadView() != null) {
                getDownloadView().a(bdUniqueId, this.aHj);
            }
            if (getGameIconTextView() != null) {
                int p = p(this.aHj);
                if (p == 1) {
                    setEnabled(false);
                    if (getDownloadView() != null) {
                        getDownloadView().setVisibility(8);
                    }
                    getGameIconTextView().setVisibility(0);
                    getGameIconTextView().setText(this.mContext.getString(com.baidu.tieba.y.game_center_waiting));
                    getGameIconTextView().setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.game_center_status_waiting));
                    com.baidu.tbadk.core.util.aw.b(getGameIconTextView(), com.baidu.tieba.s.cp_cont_d, 1);
                    return;
                }
                setEnabled(true);
                if (getDownloadView() != null) {
                    getDownloadView().setVisibility(0);
                }
                if (p == 0) {
                    getGameIconTextView().setVisibility(8);
                    return;
                }
                getGameIconTextView().setVisibility(0);
                if (p == 2) {
                    getGameIconTextView().setText(this.mContext.getString(com.baidu.tieba.y.game_new_icon));
                    getGameIconTextView().setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.game_list_item_status_new));
                    com.baidu.tbadk.core.util.aw.b(getGameIconTextView(), com.baidu.tieba.s.cp_cont_i, 1);
                    return;
                }
                getGameIconTextView().setText(this.mContext.getString(com.baidu.tieba.y.update));
                getGameIconTextView().setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.game_list_item_status_update));
                com.baidu.tbadk.core.util.aw.b(getGameIconTextView(), com.baidu.tieba.s.cp_cont_i, 1);
            }
        }
    }

    public final void a(BdUniqueId bdUniqueId, GameInfoData gameInfoData) {
        this.aHj = gameInfoData;
        h(bdUniqueId);
    }

    public void onChangeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(i == 1);
            baseActivity.getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
            baseFragmentActivity.getLayoutMode().L(i == 1);
            baseFragmentActivity.getLayoutMode().h(this);
        }
    }
}
