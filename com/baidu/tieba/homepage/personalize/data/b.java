package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.g implements p {
    private CardForum dFf;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dFf = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(afQ() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(afQ() + 0);
            }
            if (v.v(cardForum.forum_list) > 0) {
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

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.dFf != null) {
            return this.dFf.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ev(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean isValidate() {
        if (v.v(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean mo(int i) {
        return i == 1;
    }
}
