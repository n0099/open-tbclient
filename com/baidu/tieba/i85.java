package com.baidu.tieba;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface i85 {
    boolean isAsync() default false;

    String value() default "";
}
