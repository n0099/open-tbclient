package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText emY;

    public c(Context context) {
        super(context, (String) null, 29);
        this.elN = false;
        this.elM = 3;
        this.ekV = new TopicDetaiInputContainer(context);
        this.emY = ((TopicDetaiInputContainer) this.ekV).getInputView();
        ((TopicDetaiInputContainer) this.ekV).setHint(context.getString(R.string.say_your_point));
        this.elO = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.emY;
    }
}
