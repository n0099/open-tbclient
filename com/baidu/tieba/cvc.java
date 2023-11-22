package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes5.dex */
public class cvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumBookInfo forumBookInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumBookInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "book_id", forumBookInfo.book_id);
            qoc.a(jSONObject, PaymentConfirmActivityConfig.BOOK_TYPE, forumBookInfo.book_type);
            qoc.a(jSONObject, "book_title", forumBookInfo.book_title);
            qoc.a(jSONObject, "book_cover", forumBookInfo.book_cover);
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, forumBookInfo.author);
            qoc.a(jSONObject, "forum_pic", forumBookInfo.forum_pic);
            qoc.a(jSONObject, "show_chapter_id", forumBookInfo.show_chapter_id);
            qoc.a(jSONObject, "show_chapter_no", forumBookInfo.show_chapter_no);
            qoc.a(jSONObject, "show_chapter_title", forumBookInfo.show_chapter_title);
            qoc.a(jSONObject, "history_page_id", forumBookInfo.history_page_id);
            qoc.a(jSONObject, "history_paragraph_id", forumBookInfo.history_paragraph_id);
            qoc.a(jSONObject, "history_word_id", forumBookInfo.history_word_id);
            qoc.a(jSONObject, "history_percent", forumBookInfo.history_percent);
            qoc.a(jSONObject, "show_page_id", forumBookInfo.show_page_id);
            qoc.a(jSONObject, "show_paragraph_id", forumBookInfo.show_paragraph_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
