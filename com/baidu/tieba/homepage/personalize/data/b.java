package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class b extends g implements r {
    private CardForum dia;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dia = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(aah() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(aah() + 0);
            }
            if (v.u(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.g("" + personalForum.forum_id, -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dia != null) {
            return this.dia.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aaf() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dB(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean Ms() {
        if (v.u(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean ly(int i) {
        return i == 1;
    }
}
